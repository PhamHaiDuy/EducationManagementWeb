package fa.trainning.entities.draft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingMaterialDraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private SyllabusDraft syllabus;
    private String file;
    private String fileName;

    public TrainingMaterialDraft(SyllabusDraft syllabus, String file,String fileName) {
        this.syllabus = syllabus;
        this.file = file;
        this.fileName = fileName;
    }
}
