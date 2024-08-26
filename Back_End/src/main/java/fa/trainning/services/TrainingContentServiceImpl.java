package fa.trainning.services;

import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.TrainingContent;
import fa.trainning.dto.request.forcreate.CTrainingContent;
import fa.trainning.entities.TrainingUnit;
import fa.trainning.repositories.TrainingContentRepository;
import fa.trainning.services.template.ILearningObjectiveService;
import fa.trainning.services.template.ITrainingContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class TrainingContentServiceImpl implements ITrainingContentService {
    @Autowired
    private TrainingContentRepository trainingContentRepository;
    @Autowired
    private ILearningObjectiveService learningObjectiveService;

    @Override
    public void addTrainingContent(TrainingContent trainingContent) {
        trainingContentRepository.save(trainingContent);
    }

    @Override
    @Transactional
    public void addListTrainingContent(Set<TrainingContent> trainingContentSet,Set<CTrainingUnit> cTrainingUnitSet,
                                       TrainingUnit trainingUnit) {
        for(CTrainingUnit c :  cTrainingUnitSet) {
            Set<CTrainingContent> trainingContents = c.getTrainingContents();
            for(CTrainingContent ct : trainingContents) {
                // get learning object code by dto
                String learningObjectiveCode = ct.getLearningObjective().toString();
                LearningObjective learningObjective = learningObjectiveService.findLearningObjectiveByCode(learningObjectiveCode);
                TrainingContent trainingContent = new TrainingContent(trainingUnit,learningObjective,ct);
                trainingContentSet.add(trainingContent);
                trainingContentRepository.save(trainingContent);
                // update trainingContent id in learning objective
                learningObjectiveService.updateTrainingContent(learningObjectiveCode, trainingContent);
            }
        }
    }
}
