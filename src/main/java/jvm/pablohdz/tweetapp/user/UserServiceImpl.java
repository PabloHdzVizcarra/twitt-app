package jvm.pablohdz.tweetapp.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import jvm.pablohdz.tweetapp.exception.DataDuplicateException;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
            logger.info("The user with the email: " + userSaved.getEmail() +
                    " saved in the database");

            return userSaved;
        } catch (DataIntegrityViolationException exception) {
            throw new DataDuplicateException(user.getEmail());
        }
    }
}
