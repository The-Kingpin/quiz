package progress.quiz.service;

import progress.quiz.model.Question;

import java.util.List;

public interface QuizService {

    List<Question> getAllQuestions();

    Question saveQuestion(Question question);

    Question getQuestionById(long id) throws Exception;
}
