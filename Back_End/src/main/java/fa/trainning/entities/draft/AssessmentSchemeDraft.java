package fa.trainning.entities.draft;

import fa.trainning.dto.request.forcreate.CAssessmentScheme;
import fa.trainning.dto.request.forcreate.draft.CAssessmentSchemeDraft;
import fa.trainning.entities.Syllabus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AssessmentSchemeDraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(referencedColumnName = "topicCode")
    private SyllabusDraft syllabus;
    private int quiz;
    private int assigment;
    private int finalTest;
    private int finalTheory;
    private int finalPractice;
    private int gpa;
    public AssessmentSchemeDraft(SyllabusDraft syllabus, CAssessmentSchemeDraft ca) {
        this.syllabus = syllabus;
        this.quiz = ca.getQuiz();
        this.assigment = ca.getAssigment();
        this.finalTest = ca.getFinalTest();
        this.finalTheory = ca.getFinalTheory();
        this.finalPractice = ca.getFinalPractice();
        this.gpa = ca.getGpa();
    }

}
