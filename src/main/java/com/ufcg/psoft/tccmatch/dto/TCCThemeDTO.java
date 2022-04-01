package com.ufcg.psoft.tccmatch.dto;

import com.ufcg.psoft.tccmatch.entity.StudyArea;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@ToString
public class TCCThemeDTO {
    @NotEmpty
    private String title;

    private String description;

    private Set<StudyArea> studyAreas;
}
