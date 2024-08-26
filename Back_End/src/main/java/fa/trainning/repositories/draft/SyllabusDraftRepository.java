package fa.trainning.repositories.draft;

import fa.trainning.entities.draft.SyllabusDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusDraftRepository extends JpaRepository<SyllabusDraft, Long> {

}
