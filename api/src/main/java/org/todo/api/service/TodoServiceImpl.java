package org.todo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.todo.api.mapper.TodoMapper;
import org.todo.api.model.Todo;
import org.todo.api.payload.TodoRequest;
import org.todo.api.payload.TodoResponse;
import org.todo.api.repository.TodoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public List<TodoResponse> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream()
                .map(todoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TodoResponse getToDoById(Long id) {
        return todoRepository.findById(id)
                .map(todoMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Todo not found with id " + id));
    }

    @Override
    public TodoResponse createToDo(TodoRequest todoRequest) {
        Todo todo = todoMapper.toEntity(todoRequest);
        Todo savedTodo = todoRepository.save(todo);
        return todoMapper.toResponse(savedTodo);

    }

    @Override
    public TodoResponse updateToDo(Long id, TodoRequest todoRequest) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id " + id));
        todo.setTitle(todoRequest.getTitle());
        todo.setCompleted(todoRequest.isCompleted());
        Todo updatedTodo = todoRepository.save(todo);
        return todoMapper.toResponse(updatedTodo);
    }

    @Override
    public void deleteToDoById(Long id) {
        todoRepository.deleteById(id);
    }
}
