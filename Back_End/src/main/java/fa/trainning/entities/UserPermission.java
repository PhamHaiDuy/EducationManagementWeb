package fa.trainning.entities;

import fa.trainning.entities.Enums.EPermission;
import fa.trainning.entities.Enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public UserPermission(ERole eRole) {
        this.role = eRole;
    }
}
