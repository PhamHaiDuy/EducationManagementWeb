package fa.trainning.repositories.draft;

import fa.trainning.entities.draft.TrainingContentDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingContentDraftRepository extends JpaRepository<TrainingContentDraft, Long> {
}
