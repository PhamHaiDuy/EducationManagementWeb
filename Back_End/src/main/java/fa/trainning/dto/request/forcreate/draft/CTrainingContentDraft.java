package fa.trainning.dto.request.forcreate.draft;

import fa.trainning.entities.Enums.DeliveryType;
import fa.trainning.entities.Enums.TrainingFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CTrainingContentDraft {
    private String content;
    private String learningObjective;
    private int duration;
    private TrainingFormat trainingFormat;
    private DeliveryType deliveryType;
    private String note;
}
