package com.TodoApp.Repositories;

import com.TodoApp.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
    List<User> findAllByFirstNameOrSurname(String firstname, String surname);

    @Query
    List<User>findAllByFirstNameContaining(String firstname, Pageable page);
    @Query
    List<User>findByEmail(String email);
    @Query
    List<User>findByPhone(String phone);



}