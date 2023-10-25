package com.TodoApp.services;

import com.TodoApp.Repositories.UserRepositories;
import com.TodoApp.model.User;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateUser {
    @Autowired
    UserRepositories userRepository;
    public User createUser(User user) throws IllegalArgumentException {
        if (user.getFirstName() == null || user.getFirstName().length() < 4) {
            throw new IllegalArgumentException("Meno kratke");
        }
        if (user.getSurname() == null || user.getSurname().length() < 4) {
            throw new IllegalArgumentException("Meno kratke");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email nesmie byt prazny alebo je nespravny");
        }
        if (user.getPhone()==null){
            throw new IllegalArgumentException("Telefonne cislo nesmie byt prazny");
        }
        return userRepository.save(user);
    }
}

