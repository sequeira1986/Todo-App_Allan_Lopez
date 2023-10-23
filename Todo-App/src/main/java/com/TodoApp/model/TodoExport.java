package com.TodoApp.model;

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
