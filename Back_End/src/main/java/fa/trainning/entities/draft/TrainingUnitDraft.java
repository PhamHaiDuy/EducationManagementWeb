package fa.trainning.entities.draft;

import fa.trainning.entities.Syllabus;
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
public class TrainingUnitDraft {
    @Id
    private String unitCode;

    @Column(unique = true)
    private String unitName;

    private int dayNumber;

    @ManyToOne
    @JoinColumn(name = "syllabusDraft_id")
    private SyllabusDraft syllabus;

    @OneToMany
    private Set<TrainingContentDraft> trainingContentDrafts;

    public TrainingUnitDraft(String unitCode, String unitName, int dayNumber, SyllabusDraft syllabus) {
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.dayNumber = dayNumber;
        this.syllabus = syllabus;
    }
}
