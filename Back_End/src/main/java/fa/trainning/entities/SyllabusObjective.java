package fa.trainning.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SyllabusObjective implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private Syllabus syllabus;

    @ManyToOne
    @JoinColumn(name = "learning_objective_id")
    private LearningObjective learningObjective;

    public SyllabusObjective(Syllabus syllabus, LearningObjective learningObjective) {
        this.syllabus = syllabus;
        this.learningObjective = learningObjective;
    }
    @Transient
    public String getLearningObjectives(){
        return learningObjective.toString();
    }
    @Transient
    public String getCode(){
        return learningObjective.getCode();
    }
    @Transient
    public String getName(){
        return learningObjective.getName();
    }
    @Transient
    public String getType(){
        return learningObjective.getType();
    }
    @Transient
    public String getDescription(){
        return learningObjective.getDescription();
    }
}
