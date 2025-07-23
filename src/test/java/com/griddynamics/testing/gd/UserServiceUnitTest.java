package com.griddynamics.testing.gd;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @Test
    void greet_shouldReturnUserName() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1L)).thenReturn(new User(1L, "Alice"));

        UserService service = new UserService(mockRepo);
        assertEquals("Hello, Alice", service.greet(1L));
    }

    @Test
    void greet_shouldReturnGuestIfUserNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(2L)).thenReturn(null);

        UserService service = new UserService(mockRepo);
        assertEquals("Hello, Guest", service.greet(2L));
    }
}
