package com.ufcg.psoft.tccmatch.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> laboratories;

    private int orientationQuota;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<StudyArea> studyAreas;

    @JoinColumn(name = "professor_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<TCCTheme> tccThemes;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<RequestOrientation> requestOrientations;

    @Builder
    public Professor(String name, String email, List<String> laboratories) {
        this.name = name;
        this.email = email;
        this.laboratories = laboratories;
        this.orientationQuota = 0;
        this.studyAreas = new HashSet<StudyArea>();
        this.tccThemes = new ArrayList<TCCTheme>();
        this.requestOrientations = new ArrayList<RequestOrientation>();
    }

    public List<String> getLaboratories() {
        return new ArrayList<>(this.laboratories);
    }

    public void addStudyArea(StudyArea studyArea){
        studyAreas.add(studyArea);
    }

    public void addTCCTheme(TCCTheme tccTheme) {
        tccThemes.add(tccTheme);
    }

    public void addRequestOrientation(RequestOrientation requestOrientation) { requestOrientations.add(requestOrientation); }

}
