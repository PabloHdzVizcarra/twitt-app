package jvm.pablohdz.tweetapp.user;

import jvm.pablohdz.tweetapp.exception.DataDuplicateException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
    private final UserRepository userRepository;
    private final UtilUserService utils;

    public UserServiceImpl(
            UserRepository userRepository,
            UtilUserService utils
    ) {
        this.userRepository = userRepository;
        this.utils = utils;
    }

    @Override
    public User addUser(User user) {
        try {
            User userWithPasswordHash = utils.hashPasswordUser(user);
            User userSaved = userRepository.save(userWithPasswordHash);
            LOGGER.log(
                    Level.INFO,
                    "The user with the email: " + userSaved.getEmail()
                            + " was registered in the database"
            );

            return userSaved;
        } catch (DataIntegrityViolationException exception) {
            throw new DataDuplicateException(user.getEmail());
        }
    }
}
