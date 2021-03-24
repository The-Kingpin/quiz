package progress.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import progress.quiz.model.Question;
import progress.quiz.service.QuizService;
import progress.quiz.service.UserService;

import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("api/questions")
public class QuizController {

    private final QuizService quizService;
    private final UserService userService;

    @Autowired
    public QuizController(QuizService quizService,
                          UserService userService) {
        this.userService = userService;
        this.quizService = quizService;
    }

    @CrossOrigin
    @GetMapping
    public List<Question> getQuestionsForUser(@RequestParam String username) {
        System.out.println("GET QUESTIONS FOR: " + username);
        if (!this.userService.userExist(username)){
            return new LinkedList<>();
        }
        return this.quizService.getQuestionsForUser(username);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<HttpStatus> createQuestions(@RequestBody List<Question> questions) {
        System.out.println("CREATE QUESTION");
        try {
            for (Question question : questions) {
                this.quizService.saveQuestion(question);
            }

//            this.quizService.saveQuestion(questions);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @GetMapping("/get-by-id")
    public Question getQuestionById(long id) throws Exception {
        System.out.println("GET-BY-ID: " + id);
        return this.quizService.getQuestionById(id);
    }
}
