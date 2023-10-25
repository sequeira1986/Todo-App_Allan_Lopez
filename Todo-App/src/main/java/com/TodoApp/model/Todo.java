package com.TodoApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @Column(name = "id_task")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "description")
    private String content;

    @Column(name = "status")
    private String status;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "update_date")
    private String updateDate;

    private Boolean completed = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Todo() {
    }

    public Todo(Long id, String content, String status, String duedate, String updatedate, Boolean completed, User user) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.dueDate = duedate;
        this.updateDate = updatedate;
        this.completed = completed;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuedate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDueDate() {
        return dueDate;
    }

}
