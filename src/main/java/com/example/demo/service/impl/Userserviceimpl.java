package com.example.demo.service.impl;




import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Userservice;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class Userserviceimpl implements Userservice {
    private UserRepository userRepository;

    public Userserviceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        User user=userRepository.findById(id).get();
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user;
    }

    @Override
    public User updateUser(Integer id, User user) {
        User existingUser=userRepository.findById(id).get();
        if (existingUser == null) {
            return null;
        }
        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if ((Object) user.getAge() != null) {
            existingUser.setAge(user.getAge());
        }
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
