package com.TodoApp.controller;
import com.TodoApp.dto.TodoRecord;
import com.TodoApp.services.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/Todo",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TodoController {
    TodoService todoService;

    @GetMapping(value = "/{$idtodo}")
    public TodoRecord getTaskById(@RequestParam Long idtodo) {
        TodoRecord todo = todoService.loadTodo(idtodo);
        return todo;
    }
    public TodoRecord putTodo(@RequestParam Long idtodo){
        TodoRecord todo =todoService.putTodo(idtodo);
        return todo;
    }

}
