package com.TodoApp.services;

import com.TodoApp.model.Todo;
import com.TodoApp.model.TodoExport;
import com.TodoApp.model.TodoRecord;
import com.TodoApp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoExportServices {
    @Autowired
    TodoRepository todoRepository;
    public TodoExport exportAllTodo(){
        TodoExport export = new TodoExport();
        List<Todo> todoList = todoRepository.findAll();
        
        for(Todo todo:todoList){
            TodoRecord record = TodoRecord.builder()
                   .duedate(todo.getStatus()).build();
            export.getTodoRecordList().add(record);

            TodoRecord.todoRecordList.add(record);


        }
        return export;
    }

}
