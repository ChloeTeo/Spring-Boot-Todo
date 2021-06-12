package com.spring.todo.todoAPI.controller;

import com.spring.todo.todoAPI.exception.TodoNotFoundException;
import com.spring.todo.todoAPI.model.Todo;
import com.spring.todo.todoAPI.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/allTodo")
    public List<Todo> getAllTodo(){ return todoService.getAllTodo();}

    @GetMapping("/currentTodo")
    public List<Todo> getCurTodo(){return todoService.getCurrentTodo();}

    @GetMapping("/compTodo")
    public List<Todo> getCompTodo(){return todoService.getCompTodo();}

    @GetMapping("/getTodo/{pId}")
    public Todo getTodo(@PathVariable("pId")Long id){
        return todoService.getTodo(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping("/add")
    public void addTodo(@RequestBody Todo todo){todoService.addTodo(todo);}

    @PutMapping("/todo/{pId}")
    public void updateTodo(@RequestBody String task, @PathVariable("pId") Long Id){
        todoService.updateTodo(Id, task);
    }

    @PutMapping("/comp/{pId}")
    public void setCompleted(@PathVariable("pId") Long Id){
        todoService.toSetComplete(Id);
    }

    @DeleteMapping("/todo/{pId}")
    public void deleteTodo(@PathVariable("pid") Long Id){
        todoService.deleteTodo(Id);
    }

}
