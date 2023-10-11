package com.example.TodoApp.controlller;

import com.example.TodoApp.repository.TodoRepository;
import com.example.TodoApp.repository.UserRepository;
import com.example.TodoApp.request.AddTodoRequest;
import com.example.TodoApp.request.AddUserRequest;
import model.Todo;
import model.User;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
   private TodoRepository todoRepository;
    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }
    //add more method/endpoint
    //method to addUser from our clients
    @PostMapping
    public User addUser(@RequestBody AddUserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }
    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        userRepository.save(user);

    }
    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted( @PathVariable Long todoId){
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }
    @DeleteMapping("{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);
        }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);


        }


}