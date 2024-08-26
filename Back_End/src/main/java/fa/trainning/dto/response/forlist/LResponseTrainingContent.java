package fa.trainning.dto.response.forlist;

import fa.trainning.entities.Enums.DeliveryType;
import fa.trainning.entities.Enums.TrainingFormat;

public interface LResponseTrainingContent {
    String getContent();
    int getDuration();
    DeliveryType getDeliveryType();
    TrainingFormat getTrainingFormat();
}
