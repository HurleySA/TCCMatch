package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrientationRepository extends JpaRepository<Orientation, Long> {

    Optional<Orientation> findOrientationByStudent(Student student);
    Optional<Orientation> findOrientationByTccTheme(TCCTheme tccTheme);
    List<Orientation> findOrientationByProfessor(Professor professor);
}
