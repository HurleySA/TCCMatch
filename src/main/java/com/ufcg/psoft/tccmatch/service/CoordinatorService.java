package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.Orientation;
import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.Student;

public interface CoordinatorService {

    Student registerStudent(StudentDTO studentDTO);

    Student updateStudent(long id, StudentDTO studentDTO);

    Student deleteStudent(long id);

    Professor registerProfessor(ProfessorDTO professorDTO);

    Professor updateProfessor(long id, ProfessorDTO professorDTO);

    Professor deleteProfessor(long id);

    Orientation registerOrientation(long idStudent, long idProfessor, long idTccTheme, String period);

    String listReports();

    Orientation concludesOrientation(long orientationId, String period);
}
