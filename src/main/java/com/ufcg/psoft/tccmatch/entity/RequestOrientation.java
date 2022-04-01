package com.ufcg.psoft.tccmatch.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RequestOrientation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    private TCCTheme tccTheme;

    @OneToOne(cascade = CascadeType.ALL)
    private Professor professor;


    private boolean status;

    public RequestOrientation(Student student, TCCTheme tccTheme, Professor professor) {
        this.student = student;
        this.tccTheme = tccTheme;
        this.status = false;
        this.professor = professor;
    }
}
