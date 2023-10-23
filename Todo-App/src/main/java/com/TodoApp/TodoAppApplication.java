package com.TodoApp;

import com.TodoApp.repository.TodoRepository;
import com.TodoApp.repository.UserRepository;
import com.TodoApp.model.Todo;
import com.TodoApp.model.User;
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

		user.setFirstName("TestUser");
		user.setSurname("SurnameTest");

		Todo todo = new Todo();
		todo.setContent("ver video en YT");
		todo.setUser(user);

		user.getTodoList().add(todo);

		userRepository.save(user);


	}
}
