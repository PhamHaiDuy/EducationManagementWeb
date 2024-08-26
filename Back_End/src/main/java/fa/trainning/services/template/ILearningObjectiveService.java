package fa.trainning.services.template;

import fa.trainning.dto.request.forcreate.CLearningObjective;
import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.TrainingContent;

public interface ILearningObjectiveService {
    LearningObjective addLearningObjective(CLearningObjective learningObjectiveDTO);
    LearningObjective findLearningObjectiveByCode(String code);
    void updateTrainingContent(String codeL, TrainingContent trainingContent);
}
