package progress.quiz.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "quizes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
