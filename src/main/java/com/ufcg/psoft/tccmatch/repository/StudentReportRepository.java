package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.ReportStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReportRepository extends JpaRepository<ReportStudent, Long> {
}
