package fa.trainning.dto.request.forcreate;

import fa.trainning.entities.Enums.DeliveryType;
import fa.trainning.entities.Enums.TrainingFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CTrainingContent {
    @NotEmpty(message = "This field is required")
    private String content;
    @NotEmpty(message = "This field is required")
    private String learningObjective;
    @NotEmpty(message = "This field is required")
    private int duration;
    @NotEmpty(message = "This field is required")
    @Enumerated(EnumType.STRING)
    private TrainingFormat trainingFormat;
    @NotEmpty(message = "This field is required")
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    @NotEmpty(message = "This field is required")
    private String note;
}
