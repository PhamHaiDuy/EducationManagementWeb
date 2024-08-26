package fa.trainning.dto.response.fordetail;

import fa.trainning.dto.response.forlist.LResponseTrainingContent;
import fa.trainning.entities.Enums.DeliveryType;
import fa.trainning.entities.Enums.TrainingFormat;
import fa.trainning.entities.LearningObjective;

import java.util.List;
import java.util.Set;

public interface DResponseSyllabusOutline {
    public String getUnitCode();
    public String getUnitName();
    int getDayNumber();
    List<LResponseTrainingContent> getTrainingContents();
}
