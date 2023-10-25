package com.TodoApp.dto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoRecord {
    public String title, description, status,duedate;
    Long idtodo,iduser;
    public static List<TodoRecord> todoRecordList= new ArrayList<>();
}



