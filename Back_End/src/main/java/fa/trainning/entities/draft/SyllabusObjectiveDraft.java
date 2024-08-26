package fa.trainning.entities.draft;

import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.Syllabus;
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
public class SyllabusObjectiveDraft implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private SyllabusDraft syllabus;

    @ManyToOne
    @JoinColumn(name = "learning_objective_id")
    private LearningObjectiveDraft learningObjectiveDraft;

    public SyllabusObjectiveDraft(SyllabusDraft syllabus, LearningObjectiveDraft learningObjectiveDraft) {
        this.syllabus = syllabus;
        this.learningObjectiveDraft = learningObjectiveDraft;
    }
}
