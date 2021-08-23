package jvm.pablohdz.tweetapp.user;

import org.springframework.stereotype.Component;

import jvm.pablohdz.tweetapp.security.PasswordHashing;

/**
 * Utilities for user services
 */
@Component
public class UtilUserService {
    private final PasswordHashing passwordHashing;

    public UtilUserService(PasswordHashing passwordHashing) {
        this.passwordHashing = passwordHashing;
    }

    /**
     * Hash the user's password
     *
     * @param user an {@link User} object
     * @return A user object with hashed password
     */
    public User hashPasswordUser(User user) {
        String password = user.getPassword();
        String hashPass = passwordHashing.hash(password);
        user.setPassword(hashPass);
        return user;
    }
}
