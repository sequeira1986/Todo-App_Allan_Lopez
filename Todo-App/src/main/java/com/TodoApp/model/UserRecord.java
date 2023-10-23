package com.TodoApp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserRecord {
    protected String firstName;
    protected String sureName;
    protected String phone;
    protected String email;

}

