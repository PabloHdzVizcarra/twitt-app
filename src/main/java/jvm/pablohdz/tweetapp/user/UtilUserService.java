package jvm.pablohdz.tweetapp.user;

import jvm.pablohdz.tweetapp.security.PasswordHashing;

public class UtilUserService {
    private final PasswordHashing passwordHashing;

    public UtilUserService(PasswordHashing passwordHashing) {
        this.passwordHashing = passwordHashing;
    }

    public User hashPasswordUser(User user) {
        String password = user.getPassword();
        String hashPass = passwordHashing.hash(password);
        user.setPassword(hashPass);
        return user;
    }
}
