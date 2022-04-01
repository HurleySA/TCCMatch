package com.ufcg.psoft.tccmatch.entity;

import com.ufcg.psoft.tccmatch.entity.Enums.OrientationStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Orientation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    private Professor professor;

    @OneToOne(cascade = CascadeType.ALL)
    private TCCTheme tccTheme;

    private String period;

    private OrientationStatus status;

    public Orientation(Student student, Professor professor, TCCTheme tccTheme, String period){
        this.student = student;
        this.professor = professor;
        this.tccTheme = tccTheme;
        this.period = period;
        this.status = OrientationStatus.IN_COURSE;
    }

    public void concludesOrientation(String period) {
        if (this.status == OrientationStatus.CONCLUDED) {
            throw new RuntimeException("You can only end an orientation that is in course");
        }
        this.period = period;
        this.status = OrientationStatus.CONCLUDED;
    }
}
