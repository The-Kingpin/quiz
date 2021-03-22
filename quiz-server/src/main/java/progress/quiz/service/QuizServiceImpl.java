package progress.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progress.quiz.model.Question;
import progress.quiz.repository.QuestionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuestionRepository questionRepository;

    @Autowired
    public QuizServiceImpl(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
       return this.questionRepository.findAll();
    }

    @Override
    public Question saveQuestion(Question question) {
       return this.questionRepository.saveAndFlush(question);

    }

    @Override
    public Question getQuestionById(long id) {

        return this.questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No question with this ID"));
    }


}
