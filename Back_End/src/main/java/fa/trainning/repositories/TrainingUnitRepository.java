package fa.trainning.repositories;

import fa.trainning.dto.response.fordetail.DResponseSyllabusOutline;
import fa.trainning.dto.response.forlist.LResponseTrainingUnit;
import fa.trainning.entities.TrainingUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingUnitRepository extends JpaRepository<TrainingUnit,Long> {
    @Query("select tu " +
            "from  TrainingUnit tu " +
            "join  Syllabus s on tu.syllabus.topicCode = s.topicCode " +
            "where s.topicCode = :topicCode")
    List<DResponseSyllabusOutline> findByTopicCode(@Param("topicCode") String topicCode);
    @Query("select tu from TrainingUnit tu")
    List<LResponseTrainingUnit> findAllBy();
}
