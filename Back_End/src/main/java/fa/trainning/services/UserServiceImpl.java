package fa.trainning.services;

import fa.trainning.dto.request.forcreate.CUser;
import fa.trainning.dto.request.forupdate.UPassword;
import fa.trainning.dto.response.authen.UserLogin;
import fa.trainning.dto.response.forlist.LUserContent;
import fa.trainning.dto.response.forlist.PUserResponse;
import fa.trainning.dto.response.forupdate.UUserResponse;
import fa.trainning.entities.Enums.ERole;
import fa.trainning.entities.Enums.Gender;
import fa.trainning.entities.Enums.UserStatus;
import fa.trainning.entities.User;
import fa.trainning.entities.UserPermission;
import fa.trainning.repositories.RoleRepository;
import fa.trainning.repositories.UserPermissionRepository;
import fa.trainning.repositories.UserRepository;
import fa.trainning.services.template.IEmailService;
import fa.trainning.services.template.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User checkLogin(String email, String password) {
        System.out.println(email);
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }
        System.out.println(password);
        System.out.println(user.getPassword());
        System.out.println(bCryptPasswordEncoder.matches(password, user.getPassword()));
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return null;
        }
        return user;
    }
    
    public PUserResponse getUsers(int pageNo, int pageSize, String sortBy, String sortDir, String keyword) {
    	Page<User> users = userRepository.findAllWithFilter(
    	        keyword,
    	        PageRequest.of(pageNo, pageSize, Sort.by(sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy)))
    	    );
    	
    	List<LUserContent> content= users.getContent().stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
    	
    	 PUserResponse lPagingResponse = new PUserResponse();
         lPagingResponse.setContent(content);
         lPagingResponse.setPageNo(users.getNumber());
         lPagingResponse.setPageSize(users.getSize());
         lPagingResponse.setTotalElements(users.getTotalElements());
         lPagingResponse.setTotalPages(users.getTotalPages());
         lPagingResponse.setLast(users.isLast());

         return lPagingResponse;
    }
    
    @Override
    public User create(CUser userForCreate) {
        System.out.println(userForCreate.getRole());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        User userCreated = userRepository.findByEmail(email);
        UserPermission role = userPermissionRepository.findByRoleUserPermission(ERole.valueOf(userForCreate.getRole()));
        User user = new User();
        user.setCreatedBy(userCreated);
        user.setEmail(userForCreate.getEmail());
        user.setName(userForCreate.getName());
        user.setCreateDate(LocalDateTime.now());
        System.out.println(userForCreate.getDob());
        user.setDob(userForCreate.getDob());

        user.setGender(Gender.valueOf(userForCreate.getGender()));
        user.setPhone(userForCreate.getPhone());
        user.setStatus(UserStatus.valueOf(userForCreate.getStatus()));

        String randomPassword = generateRandomPassword(10);
        user.setPassword(bCryptPasswordEncoder.encode(randomPassword));
        emailService.sendPasswordResetEmail(userForCreate.getEmail(), randomPassword);

        userPermissionRepository.save(role);
        user.setUserPermission(role);
        User result = userRepository.save(user);
        return result;
    }
    public String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    @Override
    public UUserResponse updatePassword(UPassword password){
        User user = userRepository.findByEmail(password.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(password.getNewPassword()));
        userRepository.save(user);
        UUserResponse responseDTO = new UUserResponse();
        responseDTO.setId(user.getId());
        responseDTO.setEmail(user.getEmail());
        return responseDTO;
    }

    @Override
    @Transactional
    public Integer updateById(Long id, String name, String phone, LocalDateTime dob, Gender gender, UserStatus status) {
        return userRepository.updateById(id,name,phone,dob,gender,status);
    }

    @Override
    public User getUserByID(Long id) {
        return userRepository.getUserById(1L);
    }

    @Override
    @Transactional
    public Integer updateRoleUserById( Long permissionId ) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String  createByEmail = authentication.getName();
        if(createByEmail.equals("anonymousUser")){
            createByEmail = "huynhnguyenduchuy2310@gmail.com";
        }
      return userRepository.updateRoleById(userRepository.findByEmail(createByEmail).getId(), permissionId );
    }
    
    private LUserContent mapToDTO(User user){
    	LUserContent lUserContent = new LUserContent();
    	lUserContent.setId(user.getId());
    	lUserContent.setName(user.getName());
    	lUserContent.setEmail(user.getEmail());
    	lUserContent.setGender(user.getGender());
    	lUserContent.setDob(user.getDob());
    	lUserContent.setRole(user.getUserPermission().getRole());
        return lUserContent;
    }

    public String getCurrentLoginUserEmail() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String userEmail = authentication.getName();
		return userEmail;
    }

    @Override
    public UserLogin getCurrentLoginUser() {
    	String userEmail = getCurrentLoginUserEmail();
        User user = userRepository.findByEmail(userEmail);

        if (user != null) {
            ModelMapper modelMapper = new ModelMapper();
            UserLogin userLoginDTO = modelMapper.map(user, UserLogin.class);
            return userLoginDTO;
        } else {
            return null;
        }
    }
}
