package fa.trainning.repositories.draft;

import fa.trainning.entities.draft.AssessmentSchemeDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentSchemeDraftRepository extends JpaRepository<AssessmentSchemeDraft, Long> {
}
