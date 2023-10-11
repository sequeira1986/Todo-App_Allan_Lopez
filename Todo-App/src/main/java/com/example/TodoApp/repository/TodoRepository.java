package com.example.TodoApp.repository;

import model.Todo;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
