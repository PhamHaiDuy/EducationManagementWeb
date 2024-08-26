package fa.trainning.dto.request.forcreate.draft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CLearningObjectiveDraft {
    private String code;
    private String name;
    private String type;
    private String description;
}
