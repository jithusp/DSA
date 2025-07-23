package com.griddynamics.testing.gd;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService service;

    @Test
    void greet_shouldReturnNameFromRepo() {
        String result = service.greet(1L);
        assertEquals("Hello, Alice", result);
    }

    @Test
    void greet_shouldReturnGuest() {
        String result = service.greet(2L);
        assertEquals("Hello, Guest", result);
    }
}
