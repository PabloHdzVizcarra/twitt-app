package jvm.pablohdz.tweetapp.user;

import jvm.pablohdz.tweetapp.exception.DataDuplicateException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw  new DataDuplicateException(user.getEmail());
        }
    }
}
