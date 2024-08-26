package fa.trainning.repositories;

import fa.trainning.entities.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fa.trainning.entities.Enums.Gender;
import fa.trainning.entities.Enums.UserStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Query("SELECT U FROM User U WHERE U.id = :id")
    User getUserById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.name = :name, u.phone = :phone, u.dob = :dob, u.gender = :gender, u.status = :status WHERE u.id = :id")
    Integer updateById(@Param("id") Long id, @Param("name") String name, @Param("phone") String phone,
                    @Param("dob") LocalDateTime dob, @Param("gender") Gender gender, @Param("status") UserStatus status);
    @Modifying
    @Query("update User u set u.userPermission.id =:permissionId where u.id =:id")
    Integer updateRoleById(@Param("id") Long  id ,@Param("permissionId") Long permissionId );
    
    @Query("SELECT u FROM User u JOIN u.userPermission up WHERE " +
    	       "(:keyword is null or u.name like %:keyword%) OR " +
    	       "(:keyword is null or u.email like %:keyword%) OR " +
    	       "(:keyword is null or u.dob like %:keyword%) OR " +
    	       "(:keyword is null or u.gender like %:keyword%) OR " +
    	       "(:keyword is null or up.role like %:keyword%)")
	Page<User> findAllWithFilter(@Param("keyword") String keyword, Pageable pageable);

}
