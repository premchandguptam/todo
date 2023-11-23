package com.premlearns.springboot.todoapp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class ToDoService {


    private static List<Todo> todos = new ArrayList<>();
    private static int todoid = 0;

    static{
        todos.add(new Todo(++todoid,"premchand",
                "Spring", LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(++todoid,"premchand",
                "SpringBoot", LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(++todoid,"premchand",
                "NodeJs", LocalDate.now().plusYears(1),
                false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    /**
     * Logic to add a Todo to a todo list
     * @param username
     * @param description
     * @param targetDate
     * @param done
     */
    public void addTodo(String username,String description,
                        LocalDate targetDate,boolean done){
        Todo todo = new Todo(++todoid, username,description,
                targetDate,done);

        todos.add(todo);
    }

    public void deleleByID(int id){
        Predicate<? super Todo> predicate
                =todo -> todo.getId()==id;
        todos.removeIf(predicate);

    }




    public Todo findById(int id) {
        Predicate<? super Todo> predicate
                =todo -> todo.getId()==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleleByID(todo.getId());
        todos.add(todo);

    }
}
