package fa.trainning.services.draft_services.template;

import fa.trainning.dto.request.forcreate.CTrainingMaterial;
import fa.trainning.dto.request.forcreate.draft.CTrainingMaterialDraft;
import fa.trainning.entities.Syllabus;
import fa.trainning.entities.draft.SyllabusDraft;

import java.util.List;

public interface ITrainingMaterialDraftService {
    public void createTrainingMaterial(SyllabusDraft syllabus, List<CTrainingMaterialDraft> cTrainingMaterials);
}
