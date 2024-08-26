package fa.trainning.entities.draft;

import fa.trainning.entities.*;
import fa.trainning.entities.Enums.SyllabusPublishStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SyllabusDraft {
    @Id
    private String topicCode;
    @Column(unique = true)
    private String topicName;
    private String technicalGroup;
    private String version;
    // số học viên
    private int trainingAudience;
    private String topicOutline;
    @OneToMany(mappedBy = "syllabus")
    private Set<TrainingMaterial> trainingMaterials;
    private String trainingPrinciples;
    private String priority;
    @Enumerated(EnumType.STRING)
    private SyllabusPublishStatus publishStatus;
    @OneToOne
    private User createdBy;
    private LocalDateTime createDate;
    @OneToOne
    private User modifiedBy;
    private LocalDateTime modifiedDate;
    @OneToMany(mappedBy = "syllabus")
    private Set<TrainingProgramSyllabusDraft> trainingProgramSyllabusSet;
    @OneToMany(mappedBy = "syllabus")
    private Set<SyllabusObjectiveDraft> syllabusObjectives;
    @OneToMany(mappedBy = "syllabus")
    private Set<TrainingUnitDraft> trainingUnits;
    @OneToOne(mappedBy = "syllabus")
    private AssessmentSchemeDraft assessmentSchemes;
}
