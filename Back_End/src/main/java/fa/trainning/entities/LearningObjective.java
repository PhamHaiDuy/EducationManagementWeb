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
public class LearningObjective {
    @Id
    private String code;
    @Column(unique = true)
    private String name;
    private String type;
    private String description;
    @OneToMany
    private Set<SyllabusObjective> syllabusObjectives;
    @ManyToOne
    private TrainingContent trainingContent;

    @Override
    public String toString() {
        return  "{" +
                "code:  " + code  +
                "/n name: " + name +
                "/n type: " + type +
                "/n description: " + description +
                "}";
    }
}
