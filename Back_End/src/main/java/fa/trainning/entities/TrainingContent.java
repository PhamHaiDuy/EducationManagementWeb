package fa.trainning.entities;

import fa.trainning.dto.request.forcreate.CTrainingContent;
import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.entities.Enums.DeliveryType;
import fa.trainning.entities.Enums.TrainingFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingContent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unit_code")
    private TrainingUnit trainingUnit;

    private String content;

    @OneToOne
    private LearningObjective learningObjective;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    private int duration;

    @Enumerated(EnumType.STRING)
    private TrainingFormat trainingFormat;

    private String note;

    public TrainingContent(TrainingUnit trainingUnit, LearningObjective learningObjective, CTrainingContent ct){
        this.trainingUnit = trainingUnit;
        this.learningObjective = learningObjective;
        this.content = ct.getContent();
        this.duration = ct.getDuration();
        this.trainingFormat = ct.getTrainingFormat();
        this.deliveryType = ct.getDeliveryType();
        this.note = ct.getNote();
    }
    public TrainingContent(TrainingUnit trainingUnit, String content) {
        this.trainingUnit = trainingUnit;
        this.content = content;
    }
}
