package com.TodoApp;

import com.TodoApp.Repositories.UserRepositories;
import com.TodoApp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserRepositoryTests {
    @Autowired
    UserRepositories repository;
    @Test
    void findAllByNameOrSurname() {
        Pageable pageable = PageRequest.of(0, 2, Sort.by("prve meno"));
        List<User> userList = repository.findAllByFirstnameContaining("se", pageable);
        assertThat(userList).hasSize(1);

    }
    @Test
    void testLoadUsers() {
        List<User> userList = repository.findAll();
        assertThat(userList).isNotEmpty();
    }

    @Test
    void testLoadUsersByFirstNameOrSurename() {
        List<User> userList = repository.findAllByFirstnameOrSurename("Pedro", "macho");
    }
    @Test
    void testLoadUsersByPhone(){
        List<User>userList=repository.findByPhone(918528099L);
    }
}