package org.todo.api.service;

import org.todo.api.payload.TodoRequest;
import org.todo.api.payload.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getTodos();
    TodoResponse getToDoById(Long id);
    TodoResponse createToDo(TodoRequest todoRequest);
    TodoResponse updateToDo(Long id, TodoRequest todoRequest);
    void deleteToDoById(Long id);
}
