package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.Student;

public interface CoordinatorService {

    Student registerStudent(StudentDTO studentDTO);

    Student updateStudant(long id, StudentDTO studentDTO);

    Student deleteStudant(long id);

    Professor registerProfessor(ProfessorDTO professorDTO);

    Professor updateProfessor(long id, ProfessorDTO professorDTO);

    Professor deleteProfessor(long id);
}
