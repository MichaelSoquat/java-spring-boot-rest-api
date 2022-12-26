package com.example.firstrestapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @GetMapping("/greet")
    public ResponseEntity<String> hello(@RequestParam(value="name") String name) {
        if(name.equals("admin")) {
            return new ResponseEntity<String>("Hello " + name, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Todo newTodo) {
        return new ResponseEntity<Todo>(newTodo, HttpStatus.OK);
    }
}
