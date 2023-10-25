package com.TodoApp.controller;
import com.TodoApp.model.UserRecord;
import com.TodoApp.services.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/Users",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {

    @Autowired
    UserService service;

    @Tag(name="Testing")
    @GetMapping(value="/test/{id}")
    public ResponseEntity<String>test(@PathVariable("id")Long id,
                                      @RequestParam(value = "filter",required = false) String filter,@RequestBody(required = false)String body){
        if (filter==null){
            return ResponseEntity.badRequest().body("Chybne data");
        }
        if (body==null){
            return ResponseEntity.badRequest().body("Chyba request Body");
        }
        return ResponseEntity.ok("Ok");
    }

    @GetMapping(value = "/{id}")
    public UserRecord getUserById(@PathVariable Long id) {
        UserRecord user = service.loadUser(id);
        return user;
    }

    @PutMapping(value = "/{id}")
    public UserRecord updateUser(@RequestBody UserRecord user) {
        // TODO

        return null;
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteUser(@RequestParam Long id) {
        // TODO

        return true;
    }
}
