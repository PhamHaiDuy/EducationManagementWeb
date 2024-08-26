package fa.trainning.dto.response.forlist;

import java.time.LocalDateTime;

import fa.trainning.entities.Enums.ERole;
import fa.trainning.entities.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LUserContent {

	public Long id;
	public String name;
	public String email;
	public LocalDateTime dob;
	public Gender gender;
	public ERole role;
}
