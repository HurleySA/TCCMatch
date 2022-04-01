package com.ufcg.psoft.tccmatch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class OrientationDTO {

    @NotEmpty
    private long idStudent;

    @NotEmpty
    private long idProfessor;

    @NotEmpty
    private long idTccTheme;

    @NotEmpty
    private String periodo;

}
