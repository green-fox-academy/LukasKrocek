package com.example.reddit.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, String> {

    Optional<User> findUserByUserName(String userName);

    Optional<User> findFirstByPassword(String password);
    Optional<User> findFirstByCookie(String cookie);
}
