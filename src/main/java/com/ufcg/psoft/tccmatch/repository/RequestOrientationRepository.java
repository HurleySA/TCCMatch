package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.RequestOrientation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestOrientationRepository extends JpaRepository<RequestOrientation, Long> {
}
