package com.sam.TaskTrek.service;

import com.sam.TaskTrek.dto.TodoDto;
import com.sam.TaskTrek.entity.Todo;
import com.sam.TaskTrek.exception.ResourceNotFoundException;
import com.sam.TaskTrek.repo.TodoRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepo todoRepo;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = modelMapper.map(todoDto, Todo.class);
        Todo savedTodo = todoRepo.save(todo);
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAll() {
        List<Todo> list = todoRepo.findAll();
        return list.stream().map(todo -> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todo.setCompleted(todoDto.isCompleted());
        todo.setDescription(todoDto.getDescription());
        todo.setTitle(todoDto.getTitle());
        Todo updated = todoRepo.save(todo);
        return modelMapper.map(updated, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todoRepo.delete(todo);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todo.setCompleted(Boolean.TRUE);
        Todo completedTodo = todoRepo.save(todo);
        return modelMapper.map(completedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todo.setCompleted(Boolean.FALSE);
        Todo completedTodo = todoRepo.save(todo);
        return modelMapper.map(completedTodo, TodoDto.class);
    }
}
