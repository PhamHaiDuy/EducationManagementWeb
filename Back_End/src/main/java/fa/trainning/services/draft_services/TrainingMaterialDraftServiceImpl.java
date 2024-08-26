package fa.trainning.services.draft_services;

import fa.trainning.dto.request.forcreate.CTrainingMaterial;
import fa.trainning.dto.request.forcreate.draft.CTrainingMaterialDraft;
import fa.trainning.entities.TrainingMaterial;
import fa.trainning.entities.draft.SyllabusDraft;
import fa.trainning.entities.draft.TrainingMaterialDraft;
import fa.trainning.repositories.TrainingMaterialRepository;
import fa.trainning.repositories.draft.TrainingMaterialDraftRepository;
import fa.trainning.services.draft_services.template.ITrainingMaterialDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainingMaterialDraftServiceImpl implements ITrainingMaterialDraftService {
    @Autowired
    private TrainingMaterialDraftRepository trainingMaterialRepository;
    @Override
    public void createTrainingMaterial(SyllabusDraft syllabus, List<CTrainingMaterialDraft> cTrainingMaterials) {
        for(CTrainingMaterialDraft c : cTrainingMaterials) {
            TrainingMaterialDraft t = new TrainingMaterialDraft(syllabus,c.getFile(),c.getFileName());
            trainingMaterialRepository.save(t);
        }
    }
}
