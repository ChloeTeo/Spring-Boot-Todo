package com.spring.todo.todoAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String task;

    private String complete_date;

    public Todo(){
        //default constructor
    }

    public long getId() { return id;}

    public Todo(String the_task){
        this.task = the_task;
    }

    public void setTask(String task_new) {this.task=task_new;}

    public String getTask() { return task;}

    public String getComplete_date() { return complete_date;}
}
