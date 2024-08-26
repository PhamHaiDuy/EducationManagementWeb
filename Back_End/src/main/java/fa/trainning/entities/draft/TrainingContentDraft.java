package fa.trainning.entities.draft;

import fa.trainning.dto.request.forcreate.CTrainingContent;
import fa.trainning.entities.Enums.DeliveryType;
import fa.trainning.entities.Enums.TrainingFormat;
import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.TrainingUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingContentDraft implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unit_code")
    private TrainingUnitDraft trainingUnit;

    private String content;

    @OneToOne
    private LearningObjectiveDraft learningObjective;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    private int duration;

    @Enumerated(EnumType.STRING)
    private TrainingFormat trainingFormat;

    private String note;
    public TrainingContentDraft(TrainingUnitDraft trainingUnit, LearningObjectiveDraft learningObjective, CTrainingContent ct){
        this.trainingUnit = trainingUnit;
        this.learningObjective = learningObjective;
        this.content = ct.getContent();
        this.duration = ct.getDuration();
        this.trainingFormat = ct.getTrainingFormat();
        this.deliveryType = ct.getDeliveryType();
        this.note = ct.getNote();
    }
    public TrainingContentDraft(TrainingUnitDraft trainingUnit, String content) {
        this.trainingUnit = trainingUnit;
        this.content = content;
    }
}
