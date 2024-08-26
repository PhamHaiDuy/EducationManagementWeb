package fa.trainning.entities;

import fa.trainning.dto.request.forcreate.CAssessmentScheme;
import fa.trainning.entities.Enums.DeliveryType;

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
public class AssessmentScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(referencedColumnName = "topicCode")
    private Syllabus syllabus;
    private int quiz;
    private int assigment;
    private int finalTest;
    private int finalTheory;
    private int finalPractice;
    private int gpa;
    public AssessmentScheme(Syllabus syllabus, CAssessmentScheme ca) {
        this.syllabus = syllabus;
        this.quiz = ca.getQuiz();
        this.assigment = ca.getAssigment();
        this.finalTest = ca.getFinalTest();
        this.finalTheory = ca.getFinalTheory();
        this.finalPractice = ca.getFinalPractice();
        this.gpa = ca.getGpa();
    }
}

