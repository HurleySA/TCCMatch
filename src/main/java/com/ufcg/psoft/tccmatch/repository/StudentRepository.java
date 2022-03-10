package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
