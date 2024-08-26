package fa.trainning.dto.request.forcreate.draft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CAssessmentSchemeDraft {
    private int quiz;
    private int assigment;
    private int finalTest;
    private int finalTheory;
    private int finalPractice;
    private int gpa;
}
