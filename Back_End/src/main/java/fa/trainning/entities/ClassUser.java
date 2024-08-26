package fa.trainning.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassUser implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Id
    @OneToOne
    @JoinColumn(name = "class_id")
    private Class classId;

    private String userType;
}
