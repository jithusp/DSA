package com.griddynamics.testing.gd;


import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findById(Long id) {
        return id == 1L ? new User(1L, "Alice") : null;
    }
}
