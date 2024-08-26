package fa.trainning.services.template;

import fa.trainning.dto.request.forcreate.CUserPermission;
import fa.trainning.dto.response.forlist.LResponseUserPermission;
import fa.trainning.entities.Enums.EPermission;
import fa.trainning.entities.Enums.ERole;
import fa.trainning.entities.User;
import fa.trainning.entities.UserPermission;

import java.util.List;

public interface IUserPermissionService {
    List<LResponseUserPermission>findAllBy();
    Long getIdByRoleName(ERole role) ;
    Integer updateById(Long id, ERole role, EPermission classes, EPermission learningMaterial, EPermission syllabus,
                       EPermission trainingProgram, EPermission userManagement);
    UserPermission getUserPermissionById(Long id);
    UserPermission createUserPermission(CUserPermission userPermissionDTO);
}
