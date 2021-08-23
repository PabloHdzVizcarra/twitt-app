package jvm.pablohdz.tweetapp.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordHashingTest {

    private final PasswordHashing component = new PasswordHashing();

    @Test
    void canPasswordHash() {
        String password = "admin123";
        String hashPass = component.hash(password);

        assertNotEquals(hashPass, password);
    }

    @Test
    void mustComparePasswordsCorrectly() {
        String password = "admin123";
        String hashPass = component.hash(password);

        assertTrue(component.matches(hashPass, password));
        assertNotEquals(hashPass, password);
    }
}