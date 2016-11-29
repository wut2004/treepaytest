package com.test.treepay.controller;

import com.test.treepay.domain.Todo;
import com.test.treepay.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.springframework.http.ResponseEntity.ok;


@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/addTodo")
    public ResponseEntity<?> addTodo(@RequestBody Todo todotask) {
        todoRepository.save(todotask);
        return ok(Collections.singletonMap("response", "add success"));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody Todo updatetodo) {
        Todo todo = todoRepository.findOne(id);
        todo.setDate(updatetodo.getDate());
        todo.setTask(updatetodo.getTask());
        todoRepository.save(todo);
        return ok(Collections.singletonMap("response", "update success"));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTodo")
    public ResponseEntity<?> deleteTodo(@RequestParam Long id) {
        todoRepository.delete(id);
        return ok(Collections.singletonMap("response", "delete success"));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllTodo")
    public ResponseEntity<?> deleteTodo() {
        todoRepository.deleteAll();
        return ok(Collections.singletonMap("response", "delete all success"));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchAllTodo")
    public List<Todo> searchTodo() {
        ArrayList<Todo> todos = (ArrayList<Todo>) todoRepository.findAll();
        return todos;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchTodo")
    public Todo searchTodo(@RequestParam Long id) {
        Todo todo = todoRepository.findOne(id);
        return todo;
    }

}
