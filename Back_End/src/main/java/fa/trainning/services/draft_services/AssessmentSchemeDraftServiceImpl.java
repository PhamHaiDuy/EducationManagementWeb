package fa.trainning.services.draft_services;

import fa.trainning.entities.draft.AssessmentSchemeDraft;
import fa.trainning.repositories.AssessmentSchemeRepository;
import fa.trainning.repositories.draft.AssessmentSchemeDraftRepository;
import fa.trainning.services.draft_services.template.IAssessmentSchemeDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentSchemeDraftServiceImpl implements IAssessmentSchemeDraftService {
    @Autowired
    private AssessmentSchemeDraftRepository assessmentSchemeDraftRepository;
    @Override
    public void addAssessmentSchemeDraftService(AssessmentSchemeDraft assessmentScheme) {
        assessmentSchemeDraftRepository.save(assessmentScheme);
    }
}
