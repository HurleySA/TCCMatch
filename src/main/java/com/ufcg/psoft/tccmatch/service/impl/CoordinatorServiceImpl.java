package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.service.CoordinatorService;
import com.ufcg.psoft.tccmatch.service.ProfessorService;
import com.ufcg.psoft.tccmatch.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {

    @Autowired
    StudentService studentService;

    @Autowired
    ProfessorService professorService;

    @Override
    public Student registerStudent(StudentDTO studentDTO) {

        return studentService.createStudent(studentDTO);
    }

    @Override
    public Student updateStudant(long id, StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);}

    @Override
    public Student deleteStudant(long id) {

        return studentService.deleteStudant(id);
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

}
