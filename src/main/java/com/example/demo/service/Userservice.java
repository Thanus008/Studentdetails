package com.example.demo.service;
import com.example.demo.domain.User;

import java.util.List;
public interface Userservice {
    User addUser(User user);

    List<User> getUsers();

    User getUserById(Integer id);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);
}
