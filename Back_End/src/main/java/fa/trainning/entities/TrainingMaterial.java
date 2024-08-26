package fa.trainning.entities;

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
public class TrainingMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Syllabus syllabus;
    private String file;
    private String fileName;
    private String description;

    public TrainingMaterial(Syllabus syllabus, String file,String fileName) {
        this.syllabus = syllabus;
        this.file = file;
        this.fileName = fileName;
    }
}
