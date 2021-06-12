package com.spring.todo.todoAPI.repository;

import com.spring.todo.todoAPI.model.Todo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE todo t set t.task = :new_task where t.id = :id")
    void updateTask(@Param("new_task") String new_task, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE todo t set t.complete_date = :date where t.id = :id")
    void setComplete(@Param("date") String date, @Param("id") Long id);

    @Query("SELECT t from todo as t where t.complete_date = null")
    List<Todo> getCurrentTodo();

    @Query("SELECT t from todo as t where t.complete_date <> null")
    List<Todo> getCompTodo();

}
