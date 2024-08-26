package fa.trainning.services.draft_services;

import fa.trainning.dto.request.forcreate.draft.CLearningObjectiveDraft;
import fa.trainning.entities.draft.LearningObjectiveDraft;
import fa.trainning.entities.draft.TrainingContentDraft;
import fa.trainning.repositories.draft.LearningObjectiveDraftRepository;
import fa.trainning.services.draft_services.template.ILearningObjectiveDraftService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningObjectiveDraftServiceImpl implements ILearningObjectiveDraftService {
    @Autowired
    private LearningObjectiveDraftRepository learningObjectiveDraftRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public LearningObjectiveDraft addLearningObjectiveDraft(CLearningObjectiveDraft cLearningObjectiveDraftDTO) {
        LearningObjectiveDraft learningObjectiveDraft = modelMapper.map(cLearningObjectiveDraftDTO,LearningObjectiveDraft.class);
        LearningObjectiveDraft result = learningObjectiveDraftRepository.save(learningObjectiveDraft);
        return result;
    }

    @Override
    public LearningObjectiveDraft findLearningObjectiveByCode(String code) {
        return learningObjectiveDraftRepository.findByCode(code);
    }

    @Override
    public void updateTrainingContent(String codeL, TrainingContentDraft trainingContent) {
        learningObjectiveDraftRepository.updateTrainingContent(codeL,trainingContent);
    }
}
