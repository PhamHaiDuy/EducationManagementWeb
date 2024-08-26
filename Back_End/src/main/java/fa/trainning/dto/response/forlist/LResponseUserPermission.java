package fa.trainning.dto.response.forlist;

import fa.trainning.entities.Enums.EPermission;
import fa.trainning.entities.Enums.ERole;

public interface LResponseUserPermission {
    public ERole getRole();

    public EPermission getSyllabus();

    public EPermission getTrainingProgram();

    public EPermission getClasses();

    public EPermission getLearningMaterial();

    public EPermission getUserManagement();
}
