package com.TodoApp.controlller;

import com.TodoApp.repository.TodoRepository;
import com.TodoApp.repository.UserRepository;
import com.TodoApp.request.AddTodoRequest;
import com.TodoApp.request.AddUserRequest;
import com.TodoApp.model.Todo;
import com.TodoApp.model.User;
import com.TodoApp.services.TodoExportServices;
import com.TodoApp.services.UserExportService;
import com.TodoApp.services.UserServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {
    @Autowired
   UserServices userServices;
   @Autowired
    UserExportService userExportService;
   @Autowired
    TodoExportServices todoExportServices;

    @Value("${menoAplikacie}")
    String menoAplikacie;
    @Value("${adresar}")
    String adresar;

    @Tag(name = "Testing")
    @GetMapping(value = "/test/{id}")
    public ResponseEntity<String> test(@PathVariable("id")Long id,
                                @RequestParam(value = "filter", required = false) String filter,
                                       @RequestBody(required = false) String body)  {

        if (filter == null)
            return ResponseEntity.badRequest().body("Chybne data");

        if (body == null)
            return ResponseEntity.badRequest().body("Chyba request body");

        return ResponseEntity.ok("OK");

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
        //user.setUsername(userRequest.getUsername());
        //user.setPassword(userRequest.getPassword());
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
