package com.TodoApp.model;

import com.TodoApp.dto.TodoRecord;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TodoExport {
    protected List<TodoRecord> todoRecordList= new ArrayList<>();
}
