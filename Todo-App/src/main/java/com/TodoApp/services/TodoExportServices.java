package com.TodoApp.services;
import com.TodoApp.Repositories.TodoRepositories;
import com.TodoApp.dto.TodoRecord;
import com.TodoApp.model.Todo;
import com.TodoApp.model.TodoExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoExportServices {
    @Autowired
    TodoRepositories taskRepositories;

    public TodoExport exportAllTask() {

        TodoExport export = new TodoExport();
        List<Todo> taskList = taskRepositories.findAll();
        for (Todo todo : taskList) {
            TodoRecord record = TodoRecord.builder()
                    .idtodo(todo.getId()).title(todo.getDescription()).duedate(todo.getDueDate()).status(todo.getStatus())
                    .duedate(todo.getDuedate()).iduser(todo.getId())
                    .build();

            TodoRecord.todoRecordList.add(record);
        }
        return export;

    }
}
