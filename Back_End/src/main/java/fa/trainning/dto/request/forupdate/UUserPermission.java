package fa.trainning.dto.request.forupdate;

import fa.trainning.entities.Enums.EPermission;
import fa.trainning.entities.Enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UUserPermission {
    public Long id;
    public ERole role;
    public EPermission classes;
    public EPermission learningMaterial;
    public EPermission syllabus;
    public EPermission trainingProgram;
    public EPermission userManagement;
}
