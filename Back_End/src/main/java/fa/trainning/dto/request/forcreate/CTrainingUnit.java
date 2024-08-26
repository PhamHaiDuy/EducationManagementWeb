package fa.trainning.dto.request.forcreate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CTrainingUnit {
    @NotEmpty(message = "This field is required")
    private String unitName;
    @NotEmpty(message = "This field is required")
    private int dayNumber;
    @NotEmpty(message = "This field is required")
    private Set<CTrainingContent> trainingContents;
}
