package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.dto.ProposalTCCThemeDTO;
import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.*;
import com.ufcg.psoft.tccmatch.repository.ProposalTCCThemeRepository;
import com.ufcg.psoft.tccmatch.repository.StudentRepository;
import com.ufcg.psoft.tccmatch.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudyAreaService studyAreaService;

    @Autowired
    ProfessorServiceImpl professorService;

    @Autowired
    ProposalTCCThemeService proposalTCCThemeService;

    @Autowired
    ProposalTCCThemeRepository proposalTCCThemeRepository;

    @Autowired
    OrientationService orientationService;

    @Autowired
    StudentReportService studentReportService;

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void saveExistedStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(long id) {
        Student student = this.getStudentById(id);
        studentRepository.delete(student);

        return student;
    }

    @Override
    public Student addStudyArea(long id, String studyAreaName) {
        Student student = this.getStudentById(id);
        StudyArea studyArea = studyAreaService.getStudyAreaByName(studyAreaName);
        student.addStudyArea(studyArea);
        this.saveExistedStudent(student);

        return student;
    }

    @Override
    public Set<Professor> matchProfessors(long id) {
        List<StudyArea> studyAreas = this.getStudentById(id).getStudyAreas();
        return professorService.getProfessorsAvailable(studyAreas);
    }

    @Override
    public String registerProposalTCCTheme(String enrollment, ProposalTCCThemeDTO proposalTCCThemeDTO) {
        Student student = studentRepository.findStudentByEnrollment(enrollment).orElseThrow(() -> new RuntimeException("Student not found"));
        ProposalTCCTheme proposalTCCTheme = proposalTCCThemeService.registerProposalTCCTheme(proposalTCCThemeDTO.getTitle(), proposalTCCThemeDTO.getDescription(),
                proposalTCCThemeDTO.isStatus(), proposalTCCThemeDTO.getStudyAreas(), student);
        student.addProposalTCCTheme(proposalTCCTheme);
        this.saveExistedStudent(student);
        StringBuilder saida = new StringBuilder("Email enviado para os professores: ");
        for(StudyArea studyArea: proposalTCCTheme.getStudyAreas()){
            List<Professor> professors = professorService.findByStudyArea(studyArea);
            if(professors.isEmpty()){
                throw new Error("Não há nenhum aluno com tal area de estudo");
            }else{
                for(Professor professor: professors){
                    if(!saida.toString().contains(professor.getName())){
                        saida.append(String.format("%s ", student.getName()));
                    }

                }

            }
        }
        return saida.toString();
    }

    @Override
    public List<Student> findByStudyArea(StudyArea studyArea) {
        List<Student> students = studentRepository.findAll();
        List<Student> studentsWithStudyArea = new ArrayList<>();
        for(Student student: students){
            if(student.getStudyAreas().contains(studyArea)){
                studentsWithStudyArea.add(student);
            }
        }
        return studentsWithStudyArea;
    }


    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Optional<Student> studentAlreadyExists = studentRepository.findStudentByEnrollment(studentDTO.getEnrollment());
        if(studentAlreadyExists.isPresent()){
            throw new RuntimeException("Student Already Exists");
        }
        Student student = new Student(studentDTO.getName(), studentDTO.getEnrollment(), studentDTO.getEmail(), studentDTO.getExpectedPeriod());
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(long id, StudentDTO studentDTO) {
        Student student = this.getStudentById(id);
        student.setName(studentDTO.getName());
        student.setEnrollment(studentDTO.getEnrollment());
        student.setEmail(studentDTO.getEmail());
        student.setExpectedPeriod(studentDTO.getExpectedPeriod());
        this.saveExistedStudent(student);
        return student;
    }

    @Override
    public ReportStudent registerReport(long idStudent, long idOrientation, String report) {
        Student student = this.getStudentById(idStudent);
        Orientation orientation = orientationService.getOrientationById(idOrientation);
        if(orientation.getStudent().getId() == student.getId()){
            return studentReportService.registerReport(student, orientation, report);
        }else{
            throw new RuntimeException("Orientation does not belong to this Studant.");
        }

    }

}
