package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.entity.Orientation;
import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.ReportProfessor;

import java.util.List;

public interface ProfessorReportService {
    ReportProfessor registerReport(Professor professor, Orientation orientation, String report);

    List<ReportProfessor> listReports();
}
