package com.ufcg.psoft.tccmatch.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<StudyArea> studyAreas;

    @Builder
    public TCCTheme(String title, String description, Set<StudyArea> studyAreas, Professor professor) {
        this.title = title;
        this.description = description;
        this.studyAreas = studyAreas;
        this.professor = professor;
    }

    public Set<StudyArea> getStudyAreas() {
        return new HashSet<>(this.studyAreas);
    }

    public String getStudyAreasString(Set<StudyArea> studyAreas) {
        StringBuilder result = new StringBuilder("[ ");
        for(StudyArea studyArea: studyAreas){
            result.append(String.format("%s ,", studyArea.getName()));
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("]");
        return result.toString();
    }
}
