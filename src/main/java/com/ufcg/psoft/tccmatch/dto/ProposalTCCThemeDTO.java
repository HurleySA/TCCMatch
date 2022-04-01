package com.ufcg.psoft.tccmatch.dto;

import com.ufcg.psoft.tccmatch.entity.StudyArea;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.List;


@Getter
@Setter
@ToString
public class ProposalTCCThemeDTO {

    @NotEmpty
    private String title;

    private String description;

    private boolean status;

    private List<StudyArea> studyAreas;

}

