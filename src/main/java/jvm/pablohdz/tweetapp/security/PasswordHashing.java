package jvm.pablohdz.tweetapp.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHashing {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String hash(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public Boolean matches(String hashPassword, String password) {
        return bCryptPasswordEncoder.matches(password, hashPassword);
    }
}
