package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.dto.ProposalTCCThemeDTO;
import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.*;

import java.util.List;
import java.util.Set;

public interface StudentService {

    Student createStudent(StudentDTO studentDTO);

    Student updateStudent(long id, StudentDTO studentDTO);

    Student getStudentById(long id);

    void saveExistedStudent(Student student);

    Student deleteStudent(long id);

    Student addStudyArea(long id, String studyAreaName);

    Set<Professor> matchProfessors(long id);

    String registerProposalTCCTheme(String enrollment, ProposalTCCThemeDTO proposalTCCThemeDTO);

    List<Student> findByStudyArea(StudyArea studyArea);

    ReportStudent registerReport(long idStudent, long idOrientation, String report);
}
