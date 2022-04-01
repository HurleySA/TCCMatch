package com.ufcg.psoft.tccmatch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ReportProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Professor professor;

    @OneToOne(cascade = CascadeType.ALL)
    private Orientation orientation;

    private String report;

    public ReportProfessor(Professor professor,Orientation orientation, String report){
        this.professor = professor;
        this.orientation = orientation;
        this.report = report;
    }
}
