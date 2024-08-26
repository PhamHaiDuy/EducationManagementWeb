package fa.trainning.repositories;

import fa.trainning.entities.LearningObjective;
import fa.trainning.entities.TrainingContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LearningObjectiveRepository extends JpaRepository<LearningObjective, String> {
    LearningObjective findByCode(String code);
    @Modifying
    @Query("update LearningObjective set trainingContent = :trainingContent where code = :code")
    void updateTrainingContent(@Param("code") String code, @Param("trainingContent")TrainingContent trainingContent);
}
