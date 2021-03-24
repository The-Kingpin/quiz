package progress.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progress.quiz.model.Question;
import progress.quiz.model.User;
import progress.quiz.repository.QuestionRepository;
import progress.quiz.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Autowired
    public QuizServiceImpl(QuestionRepository questionRepository,
                           UserRepository userRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestionsForUser(String username) {
        List<User> allUsers = this.userRepository.findAll();
        User currentUser= new User();

        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                currentUser = user;
                break;
            }
        }

        Set<Question> usersQuestions = new HashSet<>(currentUser.getQuestions());
        List<Question> blankQuestions = new LinkedList<>();
        for (Question question : this.questionRepository.findAll()) {
            if (!usersQuestions.contains(question)) {
                blankQuestions.add(question);
            }

            if (blankQuestions.size() == 5) {
                this.userRepository.getOne(currentUser.getId()).setQuestions(blankQuestions);
                return  blankQuestions;
            }

        }

        return blankQuestions;
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
