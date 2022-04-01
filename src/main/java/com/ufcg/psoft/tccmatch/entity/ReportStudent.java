package com.ufcg.psoft.tccmatch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ReportStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    private Orientation orientation;

    private String report;

    public ReportStudent(Student student,Orientation orientation, String report){
        this.student = student;
        this.orientation = orientation;
        this.report = report;
    }
}
