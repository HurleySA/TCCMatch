package com.ufcg.psoft.tccmatch.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginDTO {
    
    @Email
    private String email;

    @NotEmpty
    private String senha;

}
