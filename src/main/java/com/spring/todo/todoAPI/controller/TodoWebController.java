package com.spring.todo.todoAPI.controller;

import com.spring.todo.todoAPI.model.Todo;
import com.spring.todo.todoAPI.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoWebController {

    @Autowired
    TodoController todoController;

    @GetMapping("/index")
    public String getCurrentTodo(Model model){
        List<Todo> todoList = todoController.getCurTodo();

        System.out.println("size of current Todo list:" + todoList.size());

        model.addAttribute("current_todo", todoList);

        return "current_todo.html";
    }

    @GetMapping("/addTodo")
    public String addNewTodo(Model model){
        Todo todo = new Todo();
        model.addAttribute("todo", todo);

        return "addTodo.html";
    }

    @PostMapping("/saveNewTodo")
    public String updateTodo(@ModelAttribute("todo") Todo todo){

        todoController.addTodo(todo);

        return "redirect:/addTodo";
    }

    @GetMapping("/editTask/{pId}")
    public String updateTask(@PathVariable("pId") Long id, Model model){
        model.addAttribute("todo", todoController.getTodo(id));

        return "editTodo.html";
    }

    @PostMapping(value= "/updateTodo/{pId}")
    public String updateTodo(@PathVariable("pId") Long id, @ModelAttribute("todo") Todo todo){


        System.out.println("here updateTodo and task: " + todo.getTask() + " id : " + id);
        todoController.updateTodo(todo.getTask(), id);

        return "redirect:/index";
    }

    @PostMapping("/delete/{pId}")
    public String deleteTodo(@PathVariable("pId") Long id){
        todoController.deleteTodo(id);

        return "redirect:/index";
    }

    @PostMapping("/setComp/{pId}")
    public String complete(@PathVariable("pId") Long id){
        todoController.setCompleted(id);

        return "redirect:/index";
    }

    @GetMapping("/comp_todo")
    public String compPage(Model model){
        List<Todo> todo = todoController.getCompTodo();

        model.addAttribute("todoComp", todo);

        return "completed_Todo.html";
    }

}
