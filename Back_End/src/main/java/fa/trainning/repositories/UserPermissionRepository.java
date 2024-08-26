package fa.trainning.repositories;

import fa.trainning.dto.response.forlist.LResponseUserPermission;
import fa.trainning.entities.Enums.EPermission;
import fa.trainning.entities.Enums.ERole;
import fa.trainning.entities.Enums.Gender;
import fa.trainning.entities.Enums.UserStatus;
import fa.trainning.entities.User;
import fa.trainning.entities.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
    @Query("select up from UserPermission up")
    public List<LResponseUserPermission> findAllBy();

    UserPermission findByRole(ERole role);
    @Modifying
    @Query("UPDATE UserPermission up SET up.role = :role, up.classes = :classes, up.learningMaterial = :learningMaterial, up.syllabus = :syllabus, up.trainingProgram = :trainingProgram, up.userManagement = :userManagement WHERE up.id = :id")
    Integer updateById(@Param("id") Long id, @Param("role") ERole role, @Param("classes") EPermission classes,
                       @Param("learningMaterial") EPermission learningMaterial, @Param("syllabus") EPermission syllabus,
                       @Param("trainingProgram") EPermission trainingProgram, @Param("userManagement") EPermission userManagement);
    @Query("SELECT Up FROM UserPermission Up WHERE Up.id = :id")
    UserPermission getUserPermissionById(@Param("id") Long id);

    @Query("Select  up FROM UserPermission up where up.role =:role")
    UserPermission findByRoleUserPermission(@Param("role") ERole role);
}
