package com.spring.todo.todoAPI.exception;

public class TodoNotFoundException extends RuntimeException{

    private static final long serialVersionUID=1L;

    public TodoNotFoundException(Long id){
        super("The todo is not found");
    }
}
