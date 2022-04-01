package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.entity.StudyArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEnrollment(String enrollment);
}
