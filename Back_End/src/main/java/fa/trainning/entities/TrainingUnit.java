package fa.trainning.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingUnit {
    @Id
    private String unitCode;

    @Column(unique = true)
    private String unitName;

    private int dayNumber;

    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private Syllabus syllabus;

    @OneToMany
    private Set<TrainingContent> trainingContents;

    public TrainingUnit(String unitCode, String unitName, int dayNumber, Syllabus syllabus) {
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.dayNumber = dayNumber;
        this.syllabus = syllabus;
    }
}
