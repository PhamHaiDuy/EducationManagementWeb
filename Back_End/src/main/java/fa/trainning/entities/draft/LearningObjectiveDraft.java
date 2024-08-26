package fa.trainning.entities.draft;

import fa.trainning.entities.SyllabusObjective;
import fa.trainning.entities.TrainingContent;
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
public class LearningObjectiveDraft {
    @Id
    private String code;
    @Column(unique = true)
    private String name;
    private String type;
    private String description;
    @OneToMany
    private Set<SyllabusObjectiveDraft> syllabusObjectiveDrafts;
    @ManyToOne
    private TrainingContentDraft trainingContent;
}
