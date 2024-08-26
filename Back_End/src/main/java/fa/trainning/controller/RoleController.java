package fa.trainning.controller;



import fa.trainning.dto.response.authen.RoleModel;
import fa.trainning.entities.UserPermission;
import fa.trainning.services.template.IRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "Role", description = "Role's API")
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> addRole(@Valid @RequestBody RoleModel roleModel) {
		UserPermission result = roleService.create(roleModel);
		return ResponseEntity.ok().body(result);
	}
}