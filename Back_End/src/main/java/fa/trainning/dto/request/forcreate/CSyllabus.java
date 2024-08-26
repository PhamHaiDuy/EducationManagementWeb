package fa.trainning.dto.request.forcreate;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class CSyllabus {
    @NotEmpty(message = "This field is required")
    private String topicCode;
    @NotEmpty(message = "This field is required")
    private String topicName;
    @ApiModelProperty(value = "1.0")
    @NotEmpty(message = "This field is required")
    private String version;
    // số học viên
    @NotEmpty(message = "This field is required")
    private int trainingAudience;
    @NotEmpty(message = "This field is required")
    private String technicalGroup;
    @NotEmpty(message = "This field is required")
    private Set<String> syllabusObjectives;
    @NotEmpty(message = "This field is required")
    private Set<CTrainingUnit> trainingUnits;
    @NotEmpty(message = "This field is required")
    private CAssessmentScheme assessmentScheme;
    private List<CTrainingMaterial> trainingMaterials;

    public CSyllabus() {
        this.version = "1.0.0";
    }
}
