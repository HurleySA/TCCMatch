package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.entity.StudyArea;
import com.ufcg.psoft.tccmatch.repository.StudentRepository;
import com.ufcg.psoft.tccmatch.service.StudentService;
import com.ufcg.psoft.tccmatch.service.StudyAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudyAreaService studyAreaService;

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void saveExistedStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student deleteStudant(long id) {
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
    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getEnrollment(), studentDTO.getExpectedPeriod());
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


}
