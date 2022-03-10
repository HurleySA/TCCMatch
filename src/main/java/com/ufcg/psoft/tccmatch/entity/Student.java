package com.ufcg.psoft.tccmatch.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String enrollment;

    private String email;

    private String expectedPeriod;

    @OneToMany(cascade = CascadeType.ALL)
    private List<StudyArea> studyAreas;

    @Builder
    public Student(String name, String enrollment, String email, String expectedPeriod) {
        this.name = name;
        this.enrollment = enrollment;
        this.email = email;
        this.expectedPeriod = expectedPeriod;
        this.studyAreas = new ArrayList<StudyArea>();
    }

    public void addStudyArea(StudyArea studyArea){
        studyAreas.add(studyArea);
    }

}
