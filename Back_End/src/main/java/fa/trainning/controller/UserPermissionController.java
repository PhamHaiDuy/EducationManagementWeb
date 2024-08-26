package fa.trainning.controller;


import fa.trainning.dto.request.forupdate.UUser;
import fa.trainning.dto.request.forupdate.UUserPermission;
import fa.trainning.dto.response.forlist.LResponseUserPermission;
import fa.trainning.entities.User;
import fa.trainning.entities.UserPermission;
import fa.trainning.services.template.IUserPermissionService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "UserPermission", description = "UserPermission's API")
@RestController
@RequestMapping("/user-permission")
public class UserPermissionController {
    @Autowired
    private IUserPermissionService userPermissionService;
    @Autowired
    private ModelMapper modelMapper;
    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<LResponseUserPermission>> getAllUserPermission(Model model) {
        List<LResponseUserPermission> userPermissions = userPermissionService.findAllBy();
        model.addAttribute("userPermissions",userPermissions);
        return ResponseEntity.ok().body(userPermissions);
    }
    @RequestMapping(value = "/update-permission", method = RequestMethod.PUT)
    public ResponseEntity<List<UserPermission>> updateUserPermission(@Valid @RequestBody List<UUserPermission> requestUserPermission) {
        List<UserPermission> listUpdate = new ArrayList<>();
        for(UUserPermission update : requestUserPermission ) {
            userPermissionService.updateById(update.getId(), update.role, update.classes,
                    update.learningMaterial, update.syllabus, update.trainingProgram, update.userManagement);
            // this is userPermission after update
            UserPermission userPermission = userPermissionService.getUserPermissionById(update.getId());
            listUpdate.add(userPermission);
        }
        return ResponseEntity.ok().body(listUpdate);
    }
}
