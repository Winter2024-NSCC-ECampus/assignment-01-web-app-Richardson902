package org.todo.api.payload;

import lombok.Data;

@Data
public class TodoRequest {
    private String title;
    private boolean isCompleted;


}
