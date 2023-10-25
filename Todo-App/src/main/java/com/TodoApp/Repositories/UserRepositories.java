package com.TodoApp.Repositories;

import com.TodoApp.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
    List<User> findAllByFirstnameOrSurename(String firstname, String surename);

    @Query
    List<User>findAllByFirstnameContaining(String firstname, Pageable page);
    @Query
    List<User>findByEmailAddress(String emailAddress);
    @Query
    List<User>findByPhone(Long phone);



}