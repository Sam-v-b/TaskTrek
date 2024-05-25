package com.sam.TaskTrek.service;

import com.sam.TaskTrek.dto.TodoDto;
import com.sam.TaskTrek.entity.Todo;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
    List<TodoDto> getAll();
    TodoDto updateTodo(Long todoId,TodoDto todoDto);
    void deleteTodo(Long id);
    TodoDto completeTodo(Long id);
    TodoDto inCompleteTodo(Long id);
}
