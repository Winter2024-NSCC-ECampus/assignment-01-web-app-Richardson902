package org.todo.api.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todo.api.payload.TodoRequest;
import org.todo.api.payload.TodoResponse;
import org.todo.api.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todo/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllProducts() {
        List<TodoResponse> response = todoService.getTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {
        TodoResponse response = todoService.getToDoById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> addTodo(@RequestBody TodoRequest request) {
        TodoResponse response = todoService.createToDo(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestParam TodoRequest request) {
        TodoResponse response = todoService.updateToDo(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }
}
