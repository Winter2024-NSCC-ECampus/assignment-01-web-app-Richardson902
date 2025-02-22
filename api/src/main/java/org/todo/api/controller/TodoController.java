package org.todo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.api.payload.TodoDto;
import org.todo.api.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos/")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        logger.info("GET request to /api/todos");
        List<TodoDto> response = todoService.getTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id) {
        logger.info("GET request to /api/todos/{}", id);
        TodoDto response = todoService.getToDoById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto request) {
        logger.info("POST request to /api/todos with body: {}", request);
        TodoDto response = todoService.createToDo(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto request) {
        logger.info("PUT request to /api/todos/{} with body: {}", id, request);
        TodoDto response = todoService.updateToDo(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        logger.info("DELETE request to /api/todos/{}", id);
        todoService.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }
}
