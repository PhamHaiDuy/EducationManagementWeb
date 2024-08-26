package fa.trainning.dto.request.forcreate;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class CSyllabusDuplicate {
    @NotEmpty(message = "This field is required")
    private String topicCode;
    @NotEmpty(message = "This field is required")
    private String topicName;
    @ApiModelProperty(value = "1.0")
    @NotEmpty(message = "This field is required")
    private String version;
    // số học viên
    private int trainingAudience;
    private String technicalGroup;
    private Set<String> syllabusObjectives;

    public CSyllabusDuplicate() {
        this.version = "1.0.1";
    }
}
