package fa.trainning.services.template;

import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.TrainingUnit;
import fa.trainning.dto.response.forlist.LResponseTrainingUnit;
import fa.trainning.dto.response.forlist.LResponseUserPermission;

import java.util.List;
import java.util.Set;

public interface ITrainingUnitService {
    void addTrainingUnit(TrainingUnit trainingUnit);
    void addListTrainingUnit(Set<TrainingUnit> trainingUnits, Set<TrainingContent> trainingContentSet,
                             Set<CTrainingUnit> cTrainingUnitSet);
    List<LResponseTrainingUnit> findAllBy();
}
