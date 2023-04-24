package com.example.demo.storage;

import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemorySimpleDb {
    private Map<Long, User> memory = new HashMap<>();

    public List<User> getAllUsers() {
        return memory.values()
                .stream()
                .toList();
    }

    public User addUser(User user) {
        if (memory.containsValue(user)) {
            throw new UserAlreadyExistException("Такой пользователь уже существует");
        }
        memory.put(user.getAccount(), user);
        return user;
    }

    public User updateUser(User user) {
        if (!memory.containsKey(user.getAccount())) {
            throw new UserNotFoundException("Пользователь с таким id не найден");
        }
        memory.put(user.getAccount(), user);
        return user;
    }

    public User getUserById(long id) {
        if (!memory.containsKey(id)) {
            throw new UserNotFoundException("Пользователь с таким id не существует");
        }
        return memory.get(id);
    }

    public User getUserByName(String name) {
        return memory.values()
                .stream()
                .filter(x -> x.getName() == name)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователь с таким именем не существует"));
    }

    public void deleteUserById(long id) {
        if (!memory.containsKey(id)) {
            throw new UserNotFoundException("Пользователь с таким id не существует");
        }
        memory.remove(id);
    }

}
