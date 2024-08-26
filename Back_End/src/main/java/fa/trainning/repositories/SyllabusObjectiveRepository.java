package fa.trainning.repositories;

import fa.trainning.entities.SyllabusObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusObjectiveRepository extends JpaRepository<SyllabusObjective, Long> {
}
