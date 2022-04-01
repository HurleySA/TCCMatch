package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.ReportProfessor;
import com.ufcg.psoft.tccmatch.entity.ReportStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorReportRepository extends JpaRepository<ReportProfessor, Long> {
}
