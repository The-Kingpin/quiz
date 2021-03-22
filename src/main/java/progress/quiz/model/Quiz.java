package progress.quiz.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "quizes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //private List<User> users;
//    @Column(name = "questions")
//    private Set<Question> questions;

}
