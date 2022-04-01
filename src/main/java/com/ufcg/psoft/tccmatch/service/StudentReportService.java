package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.entity.Orientation;
import com.ufcg.psoft.tccmatch.entity.ReportStudent;
import com.ufcg.psoft.tccmatch.entity.Student;

import java.util.List;

public interface StudentReportService {
    ReportStudent registerReport(Student student, Orientation orientation, String report);

    List<ReportStudent> listReports();
}
