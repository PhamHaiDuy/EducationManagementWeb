package fa.trainning.services.draft_services.template;

import fa.trainning.dto.request.forcreate.CLearningObjective;
import fa.trainning.dto.request.forcreate.draft.CLearningObjectiveDraft;
import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.draft.LearningObjectiveDraft;
import fa.trainning.entities.draft.TrainingContentDraft;

public interface ILearningObjectiveDraftService {
    LearningObjectiveDraft addLearningObjectiveDraft(CLearningObjectiveDraft cLearningObjectiveDraftDTO);
    LearningObjectiveDraft findLearningObjectiveByCode(String code);
    void updateTrainingContent(String codeL, TrainingContentDraft trainingContent);
}
