package fa.trainning.services.draft_services.template;

import fa.trainning.dto.request.forcreate.draft.CSyllabusDraft;
import fa.trainning.entities.draft.SyllabusDraft;

public interface ISyllabusDraftService {
    SyllabusDraft createSyllabusDraft(CSyllabusDraft syllabusDraftDTO);
}
