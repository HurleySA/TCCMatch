package com.ufcg.psoft.tccmatch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CoordinatorDTO {

    @NotEmpty
    private String name;

    @Email
    private String email;
}
