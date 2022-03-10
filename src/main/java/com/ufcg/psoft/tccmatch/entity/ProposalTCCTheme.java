package com.ufcg.psoft.tccmatch.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

    @OneToOne
    private Student student;

    @OneToMany
    private List<StudyArea> studyAreas;

    public List<StudyArea> getStudyAreas() {
        return new ArrayList<>(this.studyAreas);
    }

}
