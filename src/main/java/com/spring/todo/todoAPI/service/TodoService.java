package com.spring.todo.todoAPI.service;

import com.spring.todo.todoAPI.model.Todo;
import com.spring.todo.todoAPI.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodo(){
        List<Todo> todo = new ArrayList<>();

        todoRepository.findAll().forEach(todo::add);

        return todo;
    }

    public Optional<Todo> getTodo(Long id){

        return todoRepository.findById(id);
    }

    public List<Todo> getCurrentTodo() {
        List<Todo> todo = new ArrayList<>();

        todoRepository.getCurrentTodo().forEach(todo::add);

        return todo;
    }

    public List<Todo> getCompTodo() {
        List<Todo> todo = new ArrayList<>();

        todoRepository.getCompTodo().forEach(todo::add);

        return todo;
    }

    public void addTodo(Todo todo){
        todoRepository.save(todo);
    }

    public void updateTodo(Long id, String new_task){
        if(todoRepository.findById(id).get()!=null){
            System.out.println("found");
            todoRepository.updateTask(new_task, id);
        }
        else{
            System.out.println("not found");
        }
    }

    public void toSetComplete(Long id){
        if(todoRepository.findById(id).get()!=null){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String date = format.format(now);
            todoRepository.setComplete(date, id);
        }
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }


}
