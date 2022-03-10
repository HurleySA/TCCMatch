package com.ufcg.psoft.tccmatch.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> laboratories;

    @Builder
    public Professor(String name, String email, List<String> laboratories) {
        this.name = name;
        this.email = email;
        this.laboratories = laboratories;
    }

    public List<String> getLaboratories() {
        return new ArrayList<>(this.laboratories);
    }

}
