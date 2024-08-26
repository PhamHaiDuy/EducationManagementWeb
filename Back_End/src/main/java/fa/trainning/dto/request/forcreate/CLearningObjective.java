package fa.trainning.dto.request.forcreate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CLearningObjective {
    @NotEmpty(message = "This field is required")
    private String code;
    @NotEmpty(message = "This field is required")
    private String name;
    @NotEmpty(message = "This field is required")
    private String type;
    @NotEmpty(message = "This field is required")
    private String description;
}
