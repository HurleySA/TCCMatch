package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.Student;

public interface StudentService {

    Student createStudent(StudentDTO studentDTO);

    Student updateStudent(long id, StudentDTO studentDTO);

    Student getStudentById(long id);

    void saveExistedStudent(Student student);

    Student deleteStudant(long id);

    Student addStudyArea(long id, String studyAreaName);
}
