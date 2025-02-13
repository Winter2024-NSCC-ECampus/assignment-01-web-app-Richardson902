package org.todo.api.payload;

import lombok.Data;

@Data
public class TodoResponse {
    private String title;
    private boolean isCompleted;
}
