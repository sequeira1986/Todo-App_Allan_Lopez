package com.TodoApp.services;

import com.TodoApp.Repositories.UserRepositories;
import com.TodoApp.dto.UserExport;
import com.TodoApp.dto.UserRecord;
import com.TodoApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserExportService {

    @Autowired
    UserRepositories userRepository;

    public UserExport exportAllUsers() {
        UserExport userExport = new UserExport();

        List<User> users = userRepository.findAll();

        for (User user : users) {
            UserRecord record = UserRecord.builder()
                    .name(user.getFirstName())
                    .build();
            userExport.getListUser().add(record);


        }

        return userExport;
    }
}

