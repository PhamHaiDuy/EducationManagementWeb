package fa.trainning.repositories.draft;

import fa.trainning.entities.draft.SyllabusObjectiveDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusObjectiveDraftRepository extends JpaRepository<SyllabusObjectiveDraft, Long> {
}
