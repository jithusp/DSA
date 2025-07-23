package com.griddynamics.testing.gd;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String greet(Long id) {
        User user = repo.findById(id);
        return "Hello, " + (user != null ? user.getName() : "Guest");
    }
}
