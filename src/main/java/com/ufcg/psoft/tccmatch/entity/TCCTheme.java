package com.ufcg.psoft.tccmatch.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TCCTheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean status;

    @OneToOne
    private Professor professor;

    @OneToMany
    private List<StudyArea> studyAreas;

    @Builder
    public TCCTheme(String title, String description, boolean status, Professor professor, List<StudyArea> studyAreas) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.professor = professor;
        this.studyAreas = studyAreas;
    }

    public List<StudyArea> getStudyAreas() {
        return new ArrayList<>(this.studyAreas);
    }

}
