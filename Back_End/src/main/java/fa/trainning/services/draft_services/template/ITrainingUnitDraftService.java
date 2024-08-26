package fa.trainning.services.draft_services.template;

import fa.trainning.dto.request.forcreate.draft.CTrainingUnitDraft;
import fa.trainning.entities.draft.TrainingContentDraft;
import fa.trainning.entities.draft.TrainingUnitDraft;

import java.util.Set;

public interface ITrainingUnitDraftService {
    void addTrainingUnitDraft(TrainingUnitDraft trainingUnit);
    void addListTrainingUnit(Set<TrainingUnitDraft> trainingUnits, Set<TrainingContentDraft> trainingContentSet,
                             Set<CTrainingUnitDraft> cTrainingUnitSet);
}
