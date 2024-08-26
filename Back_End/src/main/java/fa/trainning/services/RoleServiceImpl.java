package fa.trainning.services;


import fa.trainning.dto.response.authen.RoleModel;
import fa.trainning.entities.Enums.ERole;
import fa.trainning.entities.UserPermission;
import fa.trainning.repositories.RoleRepository;
import fa.trainning.services.template.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public UserPermission create(RoleModel roleModel) {
		UserPermission role = new UserPermission();
		role.setRole(ERole.valueOf(roleModel.getName()));
        return roleRepository.save(role);
	}
}
