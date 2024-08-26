package fa.trainning.controller;

import fa.trainning.dto.request.forupdate.UUser;
import fa.trainning.dto.response.forupdate.UUserRole;
import fa.trainning.entities.User;
import fa.trainning.services.template.IUserPermissionService;
import fa.trainning.services.template.IUserService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import fa.trainning.dto.request.authen.LoginModel;
import fa.trainning.dto.request.forcreate.CUser;
import fa.trainning.dto.request.forupdate.UPassword;
import fa.trainning.dto.response.authen.TokenModel;
import fa.trainning.dto.response.authen.UserLogin;
import fa.trainning.dto.response.forlist.PUserResponse;
import fa.trainning.dto.response.forupdate.UUserResponse;
import fa.trainning.services.TokenAuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Api(tags = "User", description = "User's API")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserPermissionService userPermissionService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginModel loginModel, HttpServletResponse response) {
        String username = loginModel.getEmail();
        String password = loginModel.getPassword();
        System.out.println(username + password);
        User user = userService.checkLogin(username, password);
        if (user != null) {
            System.out.printf("JWTLoginFilter.attemptAuthentication: username/password= %s,%s\n", username, password);
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE:" + user.getUserPermission().getRole().toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("SYLLABUS:" + user.getUserPermission().getSyllabus().toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("TRAINING_PROGRAM:" + user.getUserPermission().getTrainingProgram().toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("CLASS:" + user.getUserPermission().getClasses().toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("LEARNING_MATERIAL:" + user.getUserPermission().getLearningMaterial().toString()));
            grantedAuthorities.add(new SimpleGrantedAuthority("USER_MANAGEMENT:" + user.getUserPermission().getUserManagement().toString()));
            TokenAuthenticationService.addAuthentication(response, username, grantedAuthorities);
            String authorizationString = response.getHeader("Authorization");
            System.out.println("Authorization String=" + authorizationString);
            TokenModel tokenModel = new TokenModel(authorizationString);

            return ResponseEntity.ok().body(tokenModel);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@Valid @RequestBody CUser cUser) {
        User result = userService.create(cUser);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@Valid @RequestBody UPassword passwordForUpdate) {
            UUserResponse result = userService.updatePassword(passwordForUpdate);
            System.out.println("Password changed");
            return ResponseEntity.ok().body(result);
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public PUserResponse getUsers(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "dob", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "desc", required = false) String sortDir,
            @RequestParam(value = "keyword", required = false) String keyword
    ){
        return userService.getUsers(pageNo, pageSize, sortBy, sortDir, keyword);
    }
    
    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@Valid @RequestBody UUser requestUser) {
        int row =  userService.updateById(requestUser.getId(), requestUser.name, requestUser.phone, requestUser.dob,
               requestUser.gender,requestUser.status);
        // this is user after update
        User user = userService.getUserByID(requestUser.id);
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/update-role",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateRole(@Valid @RequestBody UUserRole requestModel){
        Integer row = userService.updateRoleUserById(userPermissionService.getIdByRoleName(requestModel.getRole()));
        // this is user after update
        return ResponseEntity.ok().body(row);
    }

    @RequestMapping(value = "/get-current-user-login", method = RequestMethod.GET)
    public UserLogin getCurrentUserLogin() {
    	UserLogin user = userService.getCurrentLoginUser();
    	return user;
    }
}
