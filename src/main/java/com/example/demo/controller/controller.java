package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.storage.InMemorySimpleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class controller {
    private InMemorySimpleDb storage;

    @Autowired
    public controller(InMemorySimpleDb storage) {
        this.storage = storage;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return storage.getAllUsers();
    }

    @GetMapping("/user")
    public User getUserById(@PathParam("account") long account) {
        return storage.getUserById(account);
    }

    @GetMapping("/userByName")
    public User getUserByName(@PathParam("name") String name) {
        return storage.getUserByName(name);
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return storage.addUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@Valid @RequestBody User user) {
        return storage.updateUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUserById(@PathParam("account") long account) {
        storage.deleteUserById(account);
    }
}
