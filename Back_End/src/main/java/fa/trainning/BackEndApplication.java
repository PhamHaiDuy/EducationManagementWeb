package fa.trainning;

import fa.trainning.dto.request.forcreate.CUserPermission;
import fa.trainning.entities.UserPermission;
import fa.trainning.services.template.IUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static fa.trainning.entities.Enums.EPermission.*;
import static fa.trainning.entities.Enums.ERole.*;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner {
    @Autowired
    IUserPermissionService userPermissionService;
    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }
    @Override
    public void run(String... args){
//        CUserPermission userPermission1 = new CUserPermission(SUPER_ADMIN,FULL_ACCESS);
//        userPermissionService.createUserPermission(userPermission1);
//        CUserPermission userPermission2 = new CUserPermission(CLASS_ADMIN,CREATE);
//        userPermissionService.createUserPermission(userPermission2);
//        CUserPermission userPermission3 = new CUserPermission(TRAINER,VIEW);
//        userPermissionService.createUserPermission(userPermission3);
    }
}
