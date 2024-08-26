package fa.trainning.dto.response.forlist;

import fa.trainning.entities.Syllabus;

import java.util.List;
import java.util.Set;

public interface LResponseTrainingUnit {
    String getUnitCode();
    int getDayNumber();
    String getUnitName();
    List<LResponseTrainingContent> getTrainingContents();
}
