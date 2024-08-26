package fa.trainning.services;

import fa.trainning.entities.AssessmentScheme;
import fa.trainning.repositories.AssessmentSchemeRepository;
import fa.trainning.services.template.IAssessmentSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentSchemeServiceImpl implements IAssessmentSchemeService {
    @Autowired
    private AssessmentSchemeRepository assessmentSchemeRepository;
    @Override
    public void addAssessmentSchemeService(AssessmentScheme assessmentScheme) {
        assessmentSchemeRepository.save(assessmentScheme);
    }
}
