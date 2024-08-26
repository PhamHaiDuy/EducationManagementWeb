package fa.trainning.services;

import fa.trainning.dto.request.forcreate.CTrainingMaterial;
import fa.trainning.entities.Syllabus;
import fa.trainning.entities.TrainingMaterial;
import fa.trainning.repositories.TrainingMaterialRepository;
import fa.trainning.services.template.ITrainingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainingMaterialServiceImpl implements ITrainingMaterialService {
    @Autowired
    private TrainingMaterialRepository trainingMaterialRepository;
    @Override
    public void createTrainingMaterial(Syllabus syllabus, List<CTrainingMaterial> cTrainingMaterials) {
        for(CTrainingMaterial c : cTrainingMaterials) {
            TrainingMaterial t = new TrainingMaterial(syllabus,c.getFile(),c.getFileName());
            trainingMaterialRepository.save(t);
        }
    }
}
