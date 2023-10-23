package com.TodoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserExport {
        List<UserRecord> listUser = new ArrayList<>();

}
