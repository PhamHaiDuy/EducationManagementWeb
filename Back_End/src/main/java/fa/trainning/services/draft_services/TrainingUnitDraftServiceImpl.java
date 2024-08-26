package fa.trainning.services.draft_services;

import fa.trainning.dto.request.forcreate.draft.CTrainingUnitDraft;
import fa.trainning.entities.draft.TrainingContentDraft;
import fa.trainning.entities.draft.TrainingUnitDraft;
import fa.trainning.repositories.draft.TrainingUnitDraftRepository;
import fa.trainning.services.draft_services.template.ITrainingContentDraftService;
import fa.trainning.services.draft_services.template.ITrainingUnitDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class TrainingUnitDraftServiceImpl implements ITrainingUnitDraftService {
    @Autowired
    private TrainingUnitDraftRepository trainingUnitRepository;
    @Autowired
    private ITrainingContentDraftService trainingContentService;
    @Override
    public void addTrainingUnitDraft(TrainingUnitDraft trainingUnit) {
        trainingUnitRepository.save(trainingUnit);
    }

    @Override
    public void addListTrainingUnit(Set<TrainingUnitDraft> trainingUnits, Set<TrainingContentDraft> trainingContentSet, Set<CTrainingUnitDraft> cTrainingUnitSet) {
        for(TrainingUnitDraft t : trainingUnits) {
            trainingUnitRepository.save(t);
            trainingContentService.addListTrainingContent(trainingContentSet,cTrainingUnitSet,t);
        }
    }
}
