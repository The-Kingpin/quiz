package progress.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import progress.quiz.helpers.UserRegister;
import progress.quiz.model.User;
import progress.quiz.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping
    public User loginUser(@RequestBody User user) {
        System.out.println("Logged in: " + user.getUsername());
        return this.userService.findUserByUsername(user.getUsername());
    }
}
