package org.todo.api.service;

import org.todo.api.payload.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getTodos();
    TodoDto getToDoById(Long id);
    TodoDto createToDo(TodoDto todoDto);
    TodoDto updateToDo(Long id, TodoDto todoDto);
    void deleteToDoById(Long id);
}
