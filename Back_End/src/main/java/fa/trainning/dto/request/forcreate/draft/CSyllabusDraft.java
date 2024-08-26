package fa.trainning.dto.request.forcreate.draft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class CSyllabusDraft {
    private String topicCode;
    private String topicName;
    private String version;
    private int trainingAudience;
    private String technicalGroup;
    private Set<String> syllabusObjectives;
    private Set<CTrainingUnitDraft> trainingUnits;
    private CAssessmentSchemeDraft assessmentScheme;
    private List<CTrainingMaterialDraft> trainingMaterials;

    public CSyllabusDraft() {
        this.version = "1.0";
    }
}
