package com.ufcg.psoft.tccmatch.dto;

import com.ufcg.psoft.tccmatch.entity.TCCTheme;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ToString
public class ProfessorDTO {
    @NotEmpty
    private String name;

    @Email
    private String email;

    private List<String> laboratories;

}
