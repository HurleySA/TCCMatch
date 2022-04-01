package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.entity.*;
import com.ufcg.psoft.tccmatch.repository.OrientationRepository;
import com.ufcg.psoft.tccmatch.repository.ProfessorRepository;
import com.ufcg.psoft.tccmatch.repository.RequestOrientationRepository;
import com.ufcg.psoft.tccmatch.service.OrientationService;
import com.ufcg.psoft.tccmatch.service.ProfessorService;
import com.ufcg.psoft.tccmatch.service.StudentService;
import com.ufcg.psoft.tccmatch.service.TCCThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrientationServiceImpl implements OrientationService {

    @Autowired
    OrientationRepository orientationRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    ProfessorService professorService;

    @Autowired
    TCCThemeService tccThemeService;

    @Autowired
    RequestOrientationRepository requestOrientationRepository;

    @Override
    public Orientation getOrientationById(long id) {
        return orientationRepository.findById(id).orElseThrow(() -> new RuntimeException(("Orientation not found.")));
    }

    @Override
    public void saveExistedOrientation(Orientation orientation) {
        orientationRepository.save(orientation);
    }

    @Override
    public Orientation createOrientation(long idStudent, long idProfessor, long idTccTheme, String period) {
        Student student = studentService.getStudentById(idStudent);
        verifyExistOrientationByStudent(student);
        Professor professor = professorService.getProfessorById(idProfessor);
        TCCTheme tccTheme = tccThemeService.getTCCThemeById(idTccTheme);
        verifyTCCisAlreadyOnAOrientation(tccTheme);
        Orientation orientation = new Orientation(student, professor,tccTheme, period);

        orientationRepository.save(orientation);

        return(orientation);
    }

    @Override
    public String requestOrientation(long idStudent, long idProfessor, long idTccTheme) {
        Student student = studentService.getStudentById(idStudent);
        List<StudyArea> studyAreas = student.getStudyAreas();
        Professor professor = professorService.getProfessorById(idProfessor);
        Set<Professor> professorAvailable = professorService.getProfessorsAvailable(studyAreas);
        List<TCCTheme> tccThemesProfessor = professor.getTccThemes();
        TCCTheme tcc = tccThemeService.getTCCThemeById(idTccTheme);
        verifyTCCisAlreadyOnAOrientation(tcc);
        verifyExistOrientationByStudent(student);

        if (professor.getOrientationQuota() > 0) {
            if(tccThemesProfessor.contains(tcc)) {
                RequestOrientation request = professorService.addRequestOrientation(professor,student, tcc);
                requestOrientationRepository.save(request);
                StringBuilder result = new StringBuilder("Email enviado para o professor: ");
                result.append(professor.getName());
                return result.toString();
            }else{
                throw new RuntimeException("TCC Theme does not belong to the Professor");
            }
        } else{
            throw new RuntimeException("Professor is not available");
        }

    }

    @Override
    public List<Orientation> getOrientationByProfessorId(long id) {
        Professor professor = professorService.getProfessorById(id);
        return orientationRepository.findOrientationByProfessor(professor);
    }

    @Override
    public Orientation concludesOrientation(long id, String period) {
        Orientation orientation = getOrientationById(id);
        orientation.concludesOrientation(period);
        saveExistedOrientation(orientation);
        return orientation;
    }

    private void verifyTCCisAlreadyOnAOrientation(TCCTheme tccTheme) {
        Optional<Orientation> orientation = orientationRepository.findOrientationByTccTheme(tccTheme);
        if(orientation.isPresent()){
            throw new RuntimeException("TCC already is on a Orientation.");
        }
    }

    private void verifyExistOrientationByStudent(Student student) {
        Optional<Orientation> orientation = orientationRepository.findOrientationByStudent(student);
        if(orientation.isPresent()){
            throw new RuntimeException("Student already is on a Orientation.");
        }
    }


}
