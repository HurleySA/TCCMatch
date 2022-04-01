package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query(value = "SELECT p FROM Professor p WHERE p.orientationQuota > 0")
    List<Professor> getProfessorWithOrientationQuota();

}
