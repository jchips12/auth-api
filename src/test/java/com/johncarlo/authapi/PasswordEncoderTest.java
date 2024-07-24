package com.johncarlo.authapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

    @Test
    public void testPasswordEncoder() {
        String actual = new BCryptPasswordEncoder().encode("sam");
        String expected = "$2a$10$3Q7Z6Q";
        Assertions.assertEquals(expected, actual);
    }
}
