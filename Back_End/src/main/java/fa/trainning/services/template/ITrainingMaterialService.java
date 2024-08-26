package fa.trainning.services.template;

import fa.trainning.dto.request.forcreate.CTrainingMaterial;
import fa.trainning.entities.Syllabus;
import fa.trainning.entities.TrainingMaterial;

import java.util.List;

public interface ITrainingMaterialService {
    void createTrainingMaterial(Syllabus syllabus, List<CTrainingMaterial> cTrainingMaterials);
}
