package com.ufcg.psoft.tccmatch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class StudentDTO {

    @NotEmpty
    private String name;

    private String enrollment;

    @Email
    private String email;

    private String expectedPeriod;

}
