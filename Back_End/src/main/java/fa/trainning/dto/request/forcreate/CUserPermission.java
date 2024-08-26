package fa.trainning.dto.request.forcreate;

import fa.trainning.entities.Enums.EPermission;
import fa.trainning.entities.Enums.ERole;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CUserPermission {
    @Enumerated(EnumType.STRING)
    private ERole role;
    @Enumerated(EnumType.STRING)
    private EPermission syllabus;
    @Enumerated(EnumType.STRING)
    private EPermission trainingProgram;
    @Enumerated(EnumType.STRING)
    private EPermission classes;
    @Enumerated(EnumType.STRING)
    private EPermission learningMaterial;
    @Enumerated(EnumType.STRING)
    private EPermission userManagement;
    public CUserPermission(ERole role, EPermission userManagement){
        this.role = role;
        this.userManagement = userManagement;
    }
}
