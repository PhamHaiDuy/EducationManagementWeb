package fa.trainning.repositories;

import fa.trainning.entities.TrainingContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingContentRepository extends JpaRepository<TrainingContent,Long> {
}
