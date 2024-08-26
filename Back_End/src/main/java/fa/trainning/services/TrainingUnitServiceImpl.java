package fa.trainning.services;

import fa.trainning.dto.request.forcreate.CTrainingUnit;
import fa.trainning.dto.response.forlist.LResponseTrainingUnit;
import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.TrainingUnit;
import fa.trainning.repositories.TrainingUnitRepository;
import fa.trainning.services.template.ITrainingContentService;
import fa.trainning.services.template.ITrainingUnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TrainingUnitServiceImpl implements ITrainingUnitService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TrainingUnitRepository trainingUnitRepository;
    @Autowired
    private ITrainingContentService trainingContentService;
    @Override
    public void addTrainingUnit(TrainingUnit trainingUnit) {
        trainingUnitRepository.save(trainingUnit);
    }

    @Override
    public void addListTrainingUnit(Set<TrainingUnit> trainingUnits, Set<TrainingContent> trainingContentSet,
                                    Set<CTrainingUnit> cTrainingUnitSet) {
        for(TrainingUnit t : trainingUnits) {
            trainingUnitRepository.save(t);
            trainingContentService.addListTrainingContent(trainingContentSet,cTrainingUnitSet,t);
        }
    }
    @Override
    public List<LResponseTrainingUnit> findAllBy() {
        List<LResponseTrainingUnit> trainingUnits = trainingUnitRepository.findAllBy();
        return trainingUnits;
    }
}
