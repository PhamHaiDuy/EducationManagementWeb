package fa.trainning.services.draft_services.template;

import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.dto.request.forcreate.draft.CTrainingUnitDraft;
import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.TrainingUnit;
import fa.trainning.entities.draft.TrainingContentDraft;
import fa.trainning.entities.draft.TrainingUnitDraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ITrainingContentDraftService {
    void addTrainingContent(TrainingContentDraft trainingContent);
    void addListTrainingContent(Set<TrainingContentDraft> trainingContentSet, Set<CTrainingUnitDraft> cTrainingUnitSet,
                                TrainingUnitDraft trainingUnit);
}
