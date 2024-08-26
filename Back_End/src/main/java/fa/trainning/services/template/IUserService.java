package fa.trainning.services.template;

import fa.trainning.entities.Enums.Gender;
import fa.trainning.entities.Enums.UserStatus;
import java.time.LocalDateTime;
import fa.trainning.dto.request.forcreate.CUser;
import fa.trainning.dto.request.forupdate.UPassword;
import fa.trainning.dto.response.authen.UserLogin;
import fa.trainning.dto.response.forlist.PUserResponse;
import fa.trainning.dto.response.forupdate.UUserResponse;
import fa.trainning.entities.User;

public interface IUserService {
    User checkLogin(String username, String password);

    User create(CUser userForCreate);

    public UUserResponse updatePassword(UPassword password);

    public Integer updateById(Long id, String name, String phone, LocalDateTime dob, Gender gender, UserStatus status);

    public User getUserByID(Long id);
    
    Integer updateRoleUserById(Long permissionId);
    
    public PUserResponse getUsers(int pageNo, int pageSize, String sortBy, String sortDir, String keyword);
    
    public UserLogin getCurrentLoginUser();
}
