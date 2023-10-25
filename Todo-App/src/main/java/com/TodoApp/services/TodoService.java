package com.TodoApp.services;

import com.TodoApp.Repositories.TodoRepositories;
import com.TodoApp.dto.TodoRecord;
import com.TodoApp.model.Todo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
@Slf4j
public class TodoService {
    @Autowired
    TodoRepositories todoRepositories;
    public TodoRecord loadTodo(Long id) {
        Optional<Todo> todoOptional = todoRepositories.findById(id);
        if (todoOptional.isEmpty()) {
            throw new IllegalArgumentException("Task nebol najdeny");
        }
        TodoRecord record = new TodoRecord();
        return record;
    }
    public TodoRecord putTodo(Long idtodo){
        Optional<Todo>todoOptional=todoRepositories.findById(idtodo);
        if (todoOptional.isEmpty()){
            throw new IllegalArgumentException("Task bol  ulozeny");
        }
        TodoRecord record=new TodoRecord();
        return record;
    }



}
