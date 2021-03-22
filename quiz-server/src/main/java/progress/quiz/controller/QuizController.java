package progress.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import progress.quiz.model.Question;
import progress.quiz.service.QuizService;

import java.util.List;


@RestController
@RequestMapping("api/questions")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        System.out.println("GET QUESTIONS");
        return this.quizService.getAllQuestions();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createQuestion(@RequestBody Question question) {
        System.out.println("CREATE QUESTION");
        try {
            this.quizService.saveQuestion(question);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-by-id")
    public Question getQuestionById(long id) throws Exception {
        System.out.println("GET-BY-ID: " + id);
        return this.quizService.getQuestionById(id);
    }
}
