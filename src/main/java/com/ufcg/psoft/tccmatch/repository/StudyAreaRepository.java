package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.StudyArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudyAreaRepository extends JpaRepository<StudyArea, Long> {
    Optional<StudyArea> findByName(String studyArea);
}
