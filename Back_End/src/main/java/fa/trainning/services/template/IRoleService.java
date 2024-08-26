package fa.trainning.services.template;


import fa.trainning.dto.response.authen.RoleModel;
import fa.trainning.entities.UserPermission;

public interface IRoleService {
	UserPermission create(RoleModel roleModel);
}
