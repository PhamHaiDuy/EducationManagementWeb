package fa.trainning.entities.draft;

import fa.trainning.entities.Syllabus;
import fa.trainning.entities.TrainingProgram;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingProgramSyllabusDraft implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private SyllabusDraft syllabus;

    @Id
    @ManyToOne
    @JoinColumn(name = "training_program_code")
    private TrainingProgramDraft trainingProgram;

    private String sequence;
}
