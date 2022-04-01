package com.ufcg.psoft.tccmatch.dto;

import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.entity.TCCTheme;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
public class RequestOrientationDTO {

    @NotEmpty
    private Student student;

    @NotEmpty
    private TCCTheme tccTheme;

    @NotEmpty
    private boolean status;
}
