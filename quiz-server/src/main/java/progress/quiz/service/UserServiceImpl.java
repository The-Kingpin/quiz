package progress.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import progress.quiz.model.User;
import progress.quiz.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


//    @Override
//    public void createUser(String username) {
//        User user = new User();
//        user.setUsername(username);
//        this.userRepository.saveAndFlush(user);
//    }

    @Override
    public boolean userExist(String username) {
        for (User user : this.userRepository.findAll()) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }

        return false;
    }

    @Override
    public User findUserByUsername(String username) {

        for (User user : this.userRepository.findAll()) {
            if (user.getUsername().equals(username)){
               return user;
            }
        }

        User user = new User();
        user.setUsername(username);
        this.userRepository.saveAndFlush(user);

        return user;
    }


}
