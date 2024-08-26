package fa.trainning.entities;

import fa.trainning.dto.response.forlist.LResponseLearningObjective;
import fa.trainning.dto.response.forlist.LResponseSyllabusObjective;
import fa.trainning.entities.Enums.SyllabusPublishStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Syllabus {
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
    private Set<TrainingProgramSyllabus> trainingProgramSyllabusSet;
    @OneToMany(mappedBy = "syllabus")
    private Set<SyllabusObjective> syllabusObjectives;
    @OneToMany(mappedBy = "syllabus")
    private Set<TrainingUnit> trainingUnits;
    @OneToOne(mappedBy = "syllabus")
    private AssessmentScheme assessmentSchemes;
}
