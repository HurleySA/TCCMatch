package com.ufcg.psoft.tccmatch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@ToString
public class ProfessorDTO {
    @NotEmpty
    private String name;

    @Email
    private String email;

    private List<String> laboratories;
}
