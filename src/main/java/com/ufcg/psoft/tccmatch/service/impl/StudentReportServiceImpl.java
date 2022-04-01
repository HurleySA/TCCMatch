package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.entity.Orientation;
import com.ufcg.psoft.tccmatch.entity.ReportStudent;
import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.repository.StudentReportRepository;
import com.ufcg.psoft.tccmatch.service.StudentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentReportServiceImpl implements StudentReportService {

    @Autowired
    StudentReportRepository studentReportRepository;
    @Override
    public ReportStudent registerReport(Student student, Orientation orientation, String report) {
        ReportStudent reportStudent = new ReportStudent(student,orientation, report);
        studentReportRepository.save(reportStudent);
        return reportStudent;
    }

    @Override
    public List<ReportStudent> listReports() {
        return studentReportRepository.findAll();
    }


}
