package com.example.demo.rest;



import com.example.demo.domain.User;

import com.example.demo.service.impl.Userserviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserResource {

    private Userserviceimpl userservice;


    public UserResource(Userserviceimpl userService) {
        this.userservice = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userservice.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userservice.getUserById(id);
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userservice.addUser(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userservice.deleteUser(id);
    }
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Integer id,@RequestBody User user){
        return userservice.updateUser(id,user);
    }
}
