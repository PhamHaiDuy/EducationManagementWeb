package fa.trainning.entities;

import fa.trainning.entities.Enums.Gender;
import fa.trainning.entities.Enums.Status;
import fa.trainning.entities.Enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String phone;
    private LocalDateTime dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "user_permission_id")
    private UserPermission userPermission;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToOne
    private User createdBy;
    private LocalDateTime createDate;

    @OneToOne
    private User modifiedBy;
    private LocalDateTime modifiedDate;

    @OneToOne
    private ClassUser classUsers;


}
