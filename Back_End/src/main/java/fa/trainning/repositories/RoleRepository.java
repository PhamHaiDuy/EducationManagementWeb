package fa.trainning.repositories;

import fa.trainning.entities.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserPermission, Long> {
}
