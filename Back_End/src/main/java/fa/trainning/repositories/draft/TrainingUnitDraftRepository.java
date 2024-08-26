package fa.trainning.repositories.draft;

import fa.trainning.entities.draft.TrainingUnitDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingUnitDraftRepository extends JpaRepository<TrainingUnitDraft, String> {
}
