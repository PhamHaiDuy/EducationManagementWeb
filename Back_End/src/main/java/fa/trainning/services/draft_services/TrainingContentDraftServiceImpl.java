package fa.trainning.services.draft_services;

import fa.trainning.dto.request.forcreate.CTrainingContent;
import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.dto.request.forcreate.draft.CTrainingUnitDraft;
import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.draft.LearningObjectiveDraft;
import fa.trainning.entities.draft.TrainingContentDraft;
import fa.trainning.entities.draft.TrainingUnitDraft;
import fa.trainning.repositories.TrainingContentRepository;
import fa.trainning.repositories.draft.TrainingContentDraftRepository;
import fa.trainning.services.draft_services.template.ILearningObjectiveDraftService;
import fa.trainning.services.draft_services.template.ITrainingContentDraftService;
import fa.trainning.services.template.ILearningObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class TrainingContentDraftServiceImpl implements ITrainingContentDraftService {
    @Autowired
    private TrainingContentDraftRepository trainingContentRepository;
    @Autowired
    private ILearningObjectiveDraftService learningObjectiveService;
    @Override
    public void addTrainingContent(TrainingContentDraft trainingContent) {

    }

    @Override
    @Transactional
    public void addListTrainingContent(Set<TrainingContentDraft> trainingContentSet, Set<CTrainingUnitDraft> cTrainingUnitSet, TrainingUnitDraft trainingUnit) {
        for(CTrainingUnitDraft c :  cTrainingUnitSet) {
            Set<CTrainingContent> trainingContents = c.getTrainingContents();
            for(CTrainingContent ct : trainingContents) {
                // get learning object code by dto
                String learningObjectiveCode = ct.getLearningObjective().toString();
                LearningObjectiveDraft learningObjective = learningObjectiveService.findLearningObjectiveByCode(learningObjectiveCode);
                TrainingContentDraft trainingContent = new TrainingContentDraft(trainingUnit,learningObjective,ct);
                trainingContentSet.add(trainingContent);
                trainingContentRepository.save(trainingContent);
                // update trainingContent id in learning objective
                learningObjectiveService.updateTrainingContent(learningObjectiveCode,trainingContent);
            }
        }
    }
}
