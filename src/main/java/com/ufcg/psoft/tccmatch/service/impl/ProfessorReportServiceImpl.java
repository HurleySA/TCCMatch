package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.entity.*;
import com.ufcg.psoft.tccmatch.repository.ProfessorReportRepository;
import com.ufcg.psoft.tccmatch.service.ProfessorReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorReportServiceImpl implements ProfessorReportService {

    @Autowired
    ProfessorReportRepository professorReportRepository;
    @Override
    public ReportProfessor registerReport(Professor professor, Orientation orientation, String report) {
        ReportProfessor reportProfessor = new ReportProfessor(professor, orientation, report);
        professorReportRepository.save(reportProfessor);
        return reportProfessor;
    }

    @Override
    public List<ReportProfessor> listReports() {
        return professorReportRepository.findAll();
    }
}
