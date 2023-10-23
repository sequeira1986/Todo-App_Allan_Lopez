package com.TodoApp.repository;

import com.TodoApp.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

        List<User>findAllByNameOrSurname(String name, String surname);
        @Query ("select a from User a where lower(u.firstname) like %:searchString% or lower(a.surname) like %:searchString%")
        List<User> findAllByAnyName(@Param("searchString") String search, Pageable page);


}
