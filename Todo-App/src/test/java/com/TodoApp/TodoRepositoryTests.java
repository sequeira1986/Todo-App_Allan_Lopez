package com.TodoApp;
import com.TodoApp.Repositories.TodoRepositories;
import com.TodoApp.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TodoRepositoryTests {
    @Autowired
    TodoRepositories repositories;
    //findById , findByTitle, findByDescription, findByStatus
    @Test
    void loadTaskById() {
        List<Todo> taskList = repositories.findById(1);
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByTitle() {
        List<Todo> taskList = repositories.findByTitle("pracovat");
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByDescription() {
        List<Todo> taskList = repositories.findByDescription("pozerat yt");
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadTaskByStatus() {
        List<Todo> taskList = repositories.findByStatus("zacate");
        assertThat(taskList).isNotEmpty();
    }

    @Test
    void loadAllTasks() {
        List<Todo> taskList = repositories.findAll();
        assertThat(taskList).isNotEmpty();
    }
}
