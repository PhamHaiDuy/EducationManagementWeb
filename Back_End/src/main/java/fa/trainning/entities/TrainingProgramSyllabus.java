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
public class TrainingProgramSyllabus implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private Syllabus syllabus;

    @Id
    @ManyToOne
    @JoinColumn(name = "training_program_code")
    private TrainingProgram trainingProgram;

    private String sequence;
}
