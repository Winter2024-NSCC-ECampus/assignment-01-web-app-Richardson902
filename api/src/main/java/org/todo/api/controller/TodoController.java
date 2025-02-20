package org.todo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.api.payload.TodoRequest;
import org.todo.api.payload.TodoResponse;
import org.todo.api.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos/")
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        logger.info("GET request to /api/todos");
        List<TodoResponse> response = todoService.getTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {
        logger.info("GET request to /api/todos/{}", id);
        TodoResponse response = todoService.getToDoById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/todos/")
    public ResponseEntity<TodoResponse> addTodo(@RequestBody TodoRequest request) {
        logger.info("POST request to /api/todos with body: {}", request);
        TodoResponse response = todoService.createToDo(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody TodoRequest request) {
        logger.info("PUT request to /api/todos/{} with body: {}", id, request);
        TodoResponse response = todoService.updateToDo(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        logger.info("DELETE request to /api/todos/{}", id);
        todoService.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }
}
