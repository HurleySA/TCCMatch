package com.ufcg.psoft.tccmatch.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProposalTCCTheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<StudyArea> studyAreas;

    public ProposalTCCTheme(String title, String description, boolean status, List<StudyArea> studyAreas, Student student) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.studyAreas = studyAreas;
        this.student = student;
    }

    public List<StudyArea> getStudyAreas() {
        return new ArrayList<>(this.studyAreas);
    }

    public String getStudyAreasString(List<StudyArea> studyAreas) {
        StringBuilder result = new StringBuilder("[ ");
        for(StudyArea studyArea: studyAreas){
            result.append(String.format("%s ,", studyArea.getName()));
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("]");
        return result.toString();
    }
}
