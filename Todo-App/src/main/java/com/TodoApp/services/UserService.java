package com.TodoApp.services;

import com.TodoApp.Repositories.UserRepositories;
import com.TodoApp.model.User;
import com.TodoApp.model.UserRecord;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Slf4j

public class UserService {
    @Autowired
    UserRepositories userRepository;
    public UserRecord loadUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User nebol najdeny");
        }

        return UserRecord.builder()
                .firstName(userOptional.get().getFirstName())
                .sureName(userOptional.get().getSurname())
                .email(userOptional.get().getEmail())
                .phone(userOptional.get().getPhone())
                .build();
    }

    public CreateUser createUser() {

        UserRecord userRecord = new UserRecord();

        List<User> users = userRepository.findAll();

        for(User user : users) {
            UserRecord record = UserRecord.builder()
                    .firstName(user.getFirstName()+ " " + user.getSurname()+" " +user
                            .getEmail()+" "+user.getPhone())
                    .build();

            userRepository.save(user);
        }
        return createUser();
    }
}
