package com.TodoApp.model;

import ch.qos.logback.core.BasicStatusManager;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TodoRecord {
   public  String title,description, duedate, updatedate,completed , user;
   Long idTodo,iduser;
   public static List<TodoRecord> todoRecordList= new ArrayList<>();

}
