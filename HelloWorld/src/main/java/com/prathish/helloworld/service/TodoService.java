package com.prathish.helloworld.service;

import com.prathish.helloworld.models.Todo;
import com.prathish.helloworld.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo Id is not found"));
    }

    public List<Todo> getAllTodos () {
        return todoRepository.findAll();
    }

    public Todo updateTodo (Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodoById (Long id) {
        todoRepository.delete(getTodoById(id));
    }

    public void deleteAll () {
        todoRepository.deleteAll();
    }

}
