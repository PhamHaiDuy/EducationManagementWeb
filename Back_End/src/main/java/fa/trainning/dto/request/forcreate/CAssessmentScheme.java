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
public class CAssessmentScheme {
    @NotEmpty(message = "This field is required")
    private int quiz;
    @NotEmpty(message = "This field is required")
    private int assigment;
    @NotEmpty(message = "This field is required")
    private int finalTest;
    @NotEmpty(message = "This field is required")
    private int finalTheory;
    @NotEmpty(message = "This field is required")
    private int finalPractice;
    @NotEmpty(message = "This field is required")
    private int gpa;
}
