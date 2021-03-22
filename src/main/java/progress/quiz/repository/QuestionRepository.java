package progress.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progress.quiz.model.Question;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
