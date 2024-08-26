package fa.trainning.dto.response.forlist;

import fa.trainning.entities.Enums.SyllabusPublishStatus;
import fa.trainning.entities.TrainingMaterial;

import java.time.LocalDateTime;
import java.util.List;

public interface LResponseSyllabus {
    String getTopicName();
    String getTopicCode();
    String getTechnicalGroup();
    int getTrainingAudience();
    String getTopicOutline();
    List<TrainingMaterial> getTrainingMaterials();
    String getTrainingPrinciples();
    SyllabusPublishStatus getPublishStatus();
    List<LResponseUser> getCreatedBy();
    LocalDateTime getCreateDate();
    List<LResponseUser> getModifiedBy();
}
