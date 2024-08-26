package fa.trainning.dto.request.forcreate;


import fa.trainning.entities.Enums.ERole;
import fa.trainning.entities.Enums.Gender;
import fa.trainning.entities.Enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CUser {

    @NotEmpty(message = "This field is required")
    private String name;

    @Email(message = "Invalid Email")
    @NotEmpty(message = "This field is required")
    private String email;

    @NotEmpty(message = "This field is required")
    private String phone;

    private LocalDateTime dob;

    private String gender;

    private String role;

    private String status;

    private Long createdBy;

    private LocalDateTime createDate;
//    public void setDobFromInputString(String dobInputString) {
//        if (dobInputString != null && !dobInputString.isEmpty()) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//            this.dob = LocalDateTime.parse(dobInputString, formatter);
//        }
//    }
}
