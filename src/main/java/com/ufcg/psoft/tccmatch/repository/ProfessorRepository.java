package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
