package com.prathish.helloworld;

import com.prathish.helloworld.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    ResponseEntity<Todo> createUser (@RequestBody Todo todo) {
        try {
            Todo createdTodo = todoService.createTodo(todo);
            return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById (@PathVariable Long id) {
        try {
            Todo getId = todoService.getTodoById(id);
            return new ResponseEntity<>(getId, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    ResponseEntity<List<Todo>> getAllTodos () {
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Todo> updateTodo (@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteTodosById (@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    ResponseEntity<Void> deleteTodos () {
        todoService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
