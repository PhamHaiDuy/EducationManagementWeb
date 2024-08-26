package fa.trainning.repositories.draft;

import fa.trainning.entities.TrainingContent;
import fa.trainning.entities.draft.LearningObjectiveDraft;
import fa.trainning.entities.draft.TrainingContentDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningObjectiveDraftRepository extends JpaRepository<LearningObjectiveDraft, Long> {
    LearningObjectiveDraft findByCode(String code);
    @Modifying
    @Query("update LearningObjectiveDraft set trainingContent  = :trainingContent where code = :code")
    void updateTrainingContent(@Param("code") String code, @Param("trainingContent") TrainingContentDraft trainingContent);
}
