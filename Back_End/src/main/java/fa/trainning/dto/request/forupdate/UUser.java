package fa.trainning.dto.request.forupdate;


import fa.trainning.entities.Enums.Gender;
import fa.trainning.entities.Enums.UserStatus;
import fa.trainning.entities.UserPermission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UUser {
    public Long id;
    public Long userPermission;
    public String name;
    public String email;
    public String phone;
    public LocalDateTime dob;
    @Enumerated(EnumType.STRING)
    public Gender gender;
    @Enumerated(EnumType.STRING)
    public UserStatus status;
}
