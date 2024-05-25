package com.sam.TaskTrek.controller;

import com.sam.TaskTrek.dto.TodoDto;
import com.sam.TaskTrek.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/todos")
public class TodoController {
    private TodoService todoService;

    // Add Todo REST API
    // http://localhost:8080/api/todos
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto saved = todoService.addTodo(todoDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get Todo REST API
    // http://localhost:8080/api/todos/get/1
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/get/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
        TodoDto toDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(toDto, HttpStatus.OK);
    }

    // Get all Todo REST API
    // http://localhost:8080/api/todos/getAll
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getAll")
    public ResponseEntity<List<TodoDto>> getAll() {
        List<TodoDto> todos = todoService.getAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // Update Todo REST API
    // http://localhost:8080/api/todos/update/1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId,
                                              @RequestBody TodoDto todoDto) {
        TodoDto updated = todoService.updateTodo(todoId, todoDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Update Todo REST API
    // http://localhost:8080/api/todos/delete/1
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>("Todo deleted Successfully", HttpStatus.OK);
    }

    // Complete Todo REST API
    // http://localhost:8080/api/todos/complete/1
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("/complete/{id}")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {
        TodoDto completed = todoService.completeTodo(todoId);
        return ResponseEntity.ok(completed);
    }

    // Complete Todo REST API
    // http://localhost:8080/api/todos/incomplete/1
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("/incomplete/{id}")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId) {
        TodoDto updated = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updated);
    }

}
