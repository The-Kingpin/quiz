package progress.quiz.service;

import progress.quiz.model.User;

public interface UserService {
//    void createUser(String username);

    boolean userExist(String username);

    User findUserByUsername(String username);
}
