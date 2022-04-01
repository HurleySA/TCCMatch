package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.*;
import com.ufcg.psoft.tccmatch.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {

    @Autowired
    StudentService studentService;

    @Autowired
    ProfessorService professorService;

    @Autowired
    OrientationService orientationService;

    @Autowired
    ProfessorReportService professorReportService;

    @Autowired
    StudentReportService studentReportService;

    @Override
    public Student registerStudent(StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @Override
    public Student updateStudent(long id, StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);}

    @Override
    public Student deleteStudent(long id) {

        return studentService.deleteStudent(id);
    }

    @Override
    public Professor registerProfessor(ProfessorDTO professorDTO) {
        return professorService.createProfessor(professorDTO);
    }

    @Override
    public Professor updateProfessor(long id, ProfessorDTO professorDTO) {
        return professorService.updateProfessor(id, professorDTO);
    }

    @Override
    public Professor deleteProfessor(long id) {
        return professorService.deleteProfessor(id);
    }

    @Override
    public Orientation registerOrientation(long idStudent, long idProfessor, long idTccTheme, String period) {
        return orientationService.createOrientation(idStudent,idProfessor,idTccTheme,period);
    }

    @Override
    public String listReports() {
        List<ReportProfessor> reportProfessors = professorReportService.listReports();
        List<ReportStudent> reportStudents = studentReportService.listReports();
        StringBuilder result = new StringBuilder();
        StringBuilder professores = new StringBuilder("Reports professores:\n");
        for(ReportProfessor reportProfessor: reportProfessors){
            professores.append((String.format("- %s -%s - %s\n",reportProfessor.getProfessor().getName(), reportProfessor.getOrientation().getTccTheme().getTitle(), reportProfessor.getReport())));
        }
        result.append(professores);
        result.append("\n --------------------------------------");
        StringBuilder alunos = new StringBuilder("\nReports alunos:\n");
        for(ReportStudent reportStudent: reportStudents){
            alunos.append((String.format("- %s -%s - %s\n",reportStudent.getStudent().getName(), reportStudent.getOrientation().getTccTheme().getTitle(), reportStudent.getReport())));
        }
        result.append(alunos);
        return result.toString();

    }

    @Override
    public Orientation concludesOrientation(long orientationId, String period) {
        return orientationService.concludesOrientation(orientationId, period);
    }

}
