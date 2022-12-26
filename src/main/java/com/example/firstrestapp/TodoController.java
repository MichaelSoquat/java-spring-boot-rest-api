package com.example.firstrestapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo")
    public ResponseEntity<Todo> get(@RequestParam(value="id") Integer id) {
        Todo newTodo = new Todo();
        newTodo.setId(id);
        newTodo.setDescription("Einkaufen");
        newTodo.setIsDone(true);

        return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);

    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Todo newTodo) {
        todoRepository.save(newTodo);

        return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);
    }
}
