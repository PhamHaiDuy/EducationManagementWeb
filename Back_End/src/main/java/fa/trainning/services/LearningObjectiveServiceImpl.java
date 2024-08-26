package fa.trainning.services;

import fa.trainning.dto.request.forcreate.CLearningObjective;
import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.draft.LearningObjectiveDraft;
import fa.trainning.repositories.LearningObjectiveRepository;
import fa.trainning.repositories.draft.LearningObjectiveDraftRepository;
import fa.trainning.services.template.ILearningObjectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LearningObjectiveServiceImpl implements ILearningObjectiveService {
    @Autowired
    private LearningObjectiveRepository learningObjectiveRepository;
    @Autowired
    private LearningObjectiveDraftRepository learningObjectiveDraftRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public LearningObjective addLearningObjective(CLearningObjective learningObjectiveDTO) {
        // map dto
        LearningObjective learningObjective = modelMapper.map(learningObjectiveDTO, LearningObjective.class);
        // map dto draft
        LearningObjectiveDraft learningObjectiveDraft = modelMapper.map(learningObjectiveDTO,LearningObjectiveDraft.class);

        LearningObjective result = learningObjectiveRepository.save(learningObjective);
        // save learning objective draft to database after save learning objective
        learningObjectiveDraftRepository.save(learningObjectiveDraft);
        return result;
    }

    @Override
    public LearningObjective findLearningObjectiveByCode(String code) {
        return learningObjectiveRepository.findByCode(code);
    }

    @Override
    public void updateTrainingContent(String code, TrainingContent trainingContent) {
        learningObjectiveRepository.updateTrainingContent(code,trainingContent);
    }
}
