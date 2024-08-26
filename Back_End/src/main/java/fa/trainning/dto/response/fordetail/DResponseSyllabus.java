package fa.trainning.dto.response.fordetail;

import fa.trainning.dto.response.forlist.LResponseLearningObjective;
import fa.trainning.dto.response.forlist.LResponseSyllabusObjective;
import fa.trainning.dto.response.forlist.LResponseTrainingUnit;

import java.util.List;
public interface DResponseSyllabus {
    public String getTopicName();
    public String getTopicCode();
    public String getVersion();
    public int getTrainingAudience();
    public String getTechnicalGroup();
    public String getTrainingMaterials();
    List<LResponseSyllabusObjective> getSyllabusObjectives();
    List<LResponseTrainingUnit> getTrainingUnits();
}
