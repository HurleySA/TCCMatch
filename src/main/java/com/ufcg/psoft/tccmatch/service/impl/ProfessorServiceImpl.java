package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.dto.TCCThemeDTO;
import com.ufcg.psoft.tccmatch.entity.*;
import com.ufcg.psoft.tccmatch.repository.ProfessorRepository;
import com.ufcg.psoft.tccmatch.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    StudyAreaService studyAreaService;

    @Autowired
    TCCThemeService tccThemeService;

    @Autowired
    ProposalTCCThemeService proposalTCCThemeService;

    @Autowired
    StudentService studentService;

    @Autowired
    OrientationService orientationService;

    @Autowired
    ProfessorReportService professorReportService;

    @Override
    public Professor getProfessorById(long id) {
        return professorRepository.findById(id).orElseThrow(() -> new RuntimeException(("Professor not found.")));
    }

    @Override
    public void saveExistedProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public Professor createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor(professorDTO.getName(), professorDTO.getEmail(), professorDTO.getLaboratories());
        professorRepository.save(professor);
        return professor;
    }

    @Override
    public Professor updateProfessor(long id, ProfessorDTO professorDTO) {
        Professor professor = this.getProfessorById(id);
        professor.setName(professorDTO.getName());
        professor.setEmail(professorDTO.getEmail());
        professor.setLaboratories(professorDTO.getLaboratories());
        this.saveExistedProfessor(professor);
        return professor;
    }

    @Override
    public Professor deleteProfessor(long id) {
        Professor professor = this.getProfessorById(id);
        professorRepository.delete(professor);

        return professor;
    }

    @Override
    public Professor addStudyArea(long id, String studyAreaName) {
        Professor professor = this.getProfessorById(id);
        StudyArea studyArea = studyAreaService.getStudyAreaByName(studyAreaName);
        professor.addStudyArea(studyArea);
        this.saveExistedProfessor(professor);

        return professor;
    }

    @Override
    public Professor changeOrientationQuota(long id, int newQuota) {
        if (newQuota < 0) {
            throw new RuntimeException("The new quota cannot be a negative number");
        }
        Professor professor = this.getProfessorById(id);
        professor.setOrientationQuota(newQuota);
        this.saveExistedProfessor(professor);
        return professor;
    }

    @Override
    public Set<Professor>  getProfessorsAvailable(List<StudyArea> studentStudyAreas) {

        Set<Professor> professorSet = new HashSet<>();
        for (Professor professor : this.professorRepository.getProfessorWithOrientationQuota()) {
            if (professor.getStudyAreas().
                    stream().
                    anyMatch(studentStudyAreas::contains)) {
                professorSet.add(professor);
            }
        }
        return professorSet;
    }

    @Override
    public String registerTCCTheme(long id, TCCThemeDTO TCCThemeDTO) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor not found"));
        TCCTheme tccTheme = tccThemeService.registerTCCTheme(TCCThemeDTO.getTitle(), TCCThemeDTO.getDescription(), TCCThemeDTO.getStudyAreas(), professor);
        //Notifica alunos que possuem area de interesse do tcc theme criado
        professor.addTCCTheme(tccTheme);
        this.saveExistedProfessor(professor);
        StringBuilder saida = new StringBuilder("Email enviado para os alunos: ");
        for(StudyArea studyArea: tccTheme.getStudyAreas()){
            List<Student> students = studentService.findByStudyArea(studyArea);
            if(students.isEmpty()){
                throw new Error("Não há nenhum aluno com tal area de estudo");
            }else{
                for(Student student: students){
                    if(!saida.toString().contains(student.getName())){
                        saida.append(String.format("%s ", student.getName()));
                    }

                }

            }
        }
        return saida.toString();

    }

    @Override
    public String listTCCThemes(long id) {
        Professor professor = getProfessorById(id);
        List<TCCTheme> themes = professor.getTccThemes();
        StringBuilder result = new StringBuilder();
        for (TCCTheme tccTheme : themes) {
            result.append(String.format("- %s - %s;\n", tccTheme.getTitle(), tccTheme.getStudyAreasString(tccTheme.getStudyAreas())));
        }
        return result.toString();
    }

    @Override
    public String listProposalTCCThemes(long id) {
        List<ProposalTCCTheme> proposalThemes = proposalTCCThemeService.getAllProposalTCCThemes();
        StringBuilder result = new StringBuilder();
        for (ProposalTCCTheme proposalTCCTheme : proposalThemes) {
            result.append(String.format("- %s - %s;\n", proposalTCCTheme.getTitle(), proposalTCCTheme.getStudyAreasString(proposalTCCTheme.getStudyAreas())));
        }
        return result.toString();
    }

    @Override
    public List<Professor> findByStudyArea(StudyArea studyArea) {
        List<Professor> professors = professorRepository.findAll();
        List<Professor> professorsWithStudyArea = new ArrayList<>();
        for(Professor professor: professors){
            if(professor.getStudyAreas().contains(studyArea)){
                professorsWithStudyArea.add(professor);
            }
        }
        return professorsWithStudyArea;
    }

    @Override
    public RequestOrientation addRequestOrientation(Professor professor, Student student, TCCTheme tccTheme) {
        RequestOrientation requestOrientation = new RequestOrientation(student, tccTheme, professor);
        professor.addRequestOrientation(requestOrientation);
        this.saveExistedProfessor(professor);
        return requestOrientation;
    }

    @Override
    public String listaRequestOrientations(long id) {
        Professor professor = getProfessorById(id);
        List<RequestOrientation> orientations = professor.getRequestOrientations();
        StringBuilder result = new StringBuilder();
        for (RequestOrientation requestOrientation : orientations) {
            result.append(String.format("- %s - %s - %s;\n", requestOrientation.getStudent().getName(), requestOrientation.getTccTheme().getTitle(), requestOrientation.getProfessor().getName()));
        }
        return result.toString();
    }

    @Override
    public String listOrientations(long id) {
        List<Orientation> orientations = orientationService.getOrientationByProfessorId(id);
        StringBuilder result = new StringBuilder();
        for(Orientation orientation: orientations){
            result.append((String.format("- %s -%s - %s\n", orientation.getStudent().getName(), orientation.getTccTheme().getTitle(),orientation.getProfessor().getName())));
        }

        return result.toString();
    }

    @Override
    public ReportProfessor registerReport(long idProfessor, long idOrientation, String report) {
        Professor professor = this.getProfessorById(idProfessor);
        Orientation orientation = orientationService.getOrientationById(idOrientation);
        if(orientation.getStudent().getId() == professor.getId()){
            return professorReportService.registerReport(professor,orientation,report);
        }else{
            throw new RuntimeException("Orientation does not belong to this Professor.");
        }
    }

}
