package org.todo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.todo.api.exception.ResourceNotFoundException;
import org.todo.api.mapper.TodoMapper;
import org.todo.api.model.Todo;
import org.todo.api.payload.TodoDto;
import org.todo.api.repository.TodoRepository;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public List<TodoDto> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream()
                .map(todoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto getToDoById(Long id) {
        return todoRepository.findById(id)
                .map(todoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
    }

    @Override
    public TodoDto createToDo(TodoDto todoDto) {
        Todo todo = todoMapper.toEntity(todoDto);
        Todo savedTodo = todoRepository.save(todo);
        return todoMapper.toDto(savedTodo);

    }

    @Override
    public TodoDto updateToDo(Long id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
        todo.setCompleted(todoDto.isCompleted());
        Todo updatedTodo = todoRepository.save(todo);
        return todoMapper.toDto(updatedTodo);
    }

    @Override
    public void deleteToDoById(Long id) {
        todoRepository.deleteById(id);
    }
}
