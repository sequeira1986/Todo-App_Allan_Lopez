package com.example.TodoApp;

import com.example.TodoApp.repository.TodoRepository;
import com.example.TodoApp.repository.UserRepository;
import model.Todo;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
	public class TodoAppApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TodoRepository todoRepository;
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		User user = new User();

		user.setPassword("perros y gatos");
		user.setUsername("Juan");

		Todo todo = new Todo();

		todo.setContent("ver video en YT");

		user.getTodoList().add(todo);

		todoRepository.save(todo);
		userRepository.save(user);


	}
}
