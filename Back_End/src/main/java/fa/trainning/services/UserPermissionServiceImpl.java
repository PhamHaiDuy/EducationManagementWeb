package fa.trainning.services;

import fa.trainning.dto.request.forcreate.CUserPermission;
import fa.trainning.dto.response.forlist.LResponseUserPermission;
import fa.trainning.entities.Enums.EPermission;
import fa.trainning.entities.Enums.ERole;
import fa.trainning.entities.User;
import fa.trainning.entities.UserPermission;
import fa.trainning.repositories.UserPermissionRepository;
import fa.trainning.services.template.IUserPermissionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserPermissionServiceImpl implements IUserPermissionService {
    @Autowired
    private  UserPermissionRepository userPermissionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<LResponseUserPermission> findAllBy(){
        List<LResponseUserPermission> userPermissions = userPermissionRepository.findAllBy();
        return userPermissions;
    }
    @Override
    public Long getIdByRoleName(ERole role) {
        return  userPermissionRepository.findByRole(role).getId();
    }

    @Override
    @Transactional
    public Integer updateById(Long id, ERole role, EPermission classes, EPermission learningMaterial, EPermission syllabus, EPermission trainingProgram, EPermission userManagement) {
        return userPermissionRepository.updateById(id,role,classes,learningMaterial,syllabus,trainingProgram,userManagement);
    }
    @Override
    public UserPermission getUserPermissionById(Long id) {
        return userPermissionRepository.getUserPermissionById(1L);
    }
    @Override
    public UserPermission createUserPermission(CUserPermission userPermissionDTO){
        UserPermission userPermission = modelMapper.map(userPermissionDTO,UserPermission.class);
        UserPermission result = userPermissionRepository.save(userPermission);
        return result;
    }
}
