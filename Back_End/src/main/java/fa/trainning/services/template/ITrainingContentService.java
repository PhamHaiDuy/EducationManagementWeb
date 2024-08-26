package fa.trainning.services.template;

import fa.trainning.dto.request.forcreate.CTrainingContent;
import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.TrainingUnit;

import java.util.Set;

public interface ITrainingContentService {
    void addTrainingContent(TrainingContent trainingContent);
    void addListTrainingContent(Set<TrainingContent> trainingContentSet,Set<CTrainingUnit> cTrainingUnitSet,
                                TrainingUnit trainingUnit);
}
