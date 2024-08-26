package fa.trainning.repositories;

import fa.trainning.entities.TrainingMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingMaterialRepository extends JpaRepository<TrainingMaterial, Long> {
}
