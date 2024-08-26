package fa.trainning.dto.request.forcreate.draft;

import fa.trainning.dto.request.forcreate.CTrainingContent;
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
public class CTrainingUnitDraft {
    private String unitName;
    private int dayNumber;
    private Set<CTrainingContent> trainingContents;
}
