package com.lebedev.controller;

import com.lebedev.exception.UserNotFoundException;
import com.lebedev.helper.MyRepository;
import com.lebedev.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final MyRepository<User> userMyRepository;

    public UserController(MyRepository<User> userMyRepository) {
        this.userMyRepository = userMyRepository;
    }

    @GetMapping("/user")
    List<User> all() {
        return userMyRepository.findAll();
    }

    @PostMapping("/user")
    User newEmployee(@RequestBody User newUser) {
        return userMyRepository.save(newUser);
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {
        if(userMyRepository.exist(id)){
            return userMyRepository.findOne(id);
        }
        else throw new UserNotFoundException("Operation read", id);
    }

    @PutMapping("/user/{id}")
    User replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {
        if(userMyRepository.exist(id)){
            return userMyRepository.update(id,newUser);
        }
        else throw new UserNotFoundException("Operation update", id);
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        if(userMyRepository.exist(id)){
            userMyRepository.delete(id);
        }
        else throw new UserNotFoundException("Operation delete", id);
    }
}
