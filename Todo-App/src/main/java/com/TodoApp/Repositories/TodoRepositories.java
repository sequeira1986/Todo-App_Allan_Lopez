package com.TodoApp.Repositories;

import com.TodoApp.model.Todo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RestResource(path = "todo")
@Repository
public interface TodoRepositories extends JpaRepository<Todo, Long> {
    Optional<Todo> findById(int id);
    @Query
    List<Todo>findByDescription(String description);
    @Query
    List<Todo>findByStatus(String status);


}
