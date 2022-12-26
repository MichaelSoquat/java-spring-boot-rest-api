package com.example.firstrestapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo")
    public ResponseEntity<Todo> get(@RequestParam(value="id") Integer id) {
        Optional<Todo> todoInDB = todoRepository.findById(id);
        if(todoInDB.isPresent()){
            return new ResponseEntity<Todo>(todoInDB.get(), HttpStatus.OK);
        }
        return new ResponseEntity("Todo not found with id" + id, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/todo/all")
    public ResponseEntity<Iterable<Todo>> getAll() {
        Iterable<Todo> allTodosInDB = todoRepository.findAll();
        return new ResponseEntity<Iterable<Todo>>(allTodosInDB, HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Todo newTodo) {
        todoRepository.save(newTodo);

        return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);
    }

    @DeleteMapping("/todo")
    public ResponseEntity delete(@RequestParam(value="id") Integer id) {
        todoRepository.deleteById(id);
        return new ResponseEntity("Todo deleted", HttpStatus.GONE);
    }
}
