package com.premlearns.springboot.todoapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ToDoService {


    private static List<Todo> todos = new ArrayList<>();

    static{
        todos.add(new Todo(1,"premchand",
                "Spring", LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(2,"premchand",
                "SpringBoot", LocalDate.now().plusYears(1),
                false));
        todos.add(new Todo(3,"premchand",
                "NodeJs", LocalDate.now().plusYears(1),
                false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

}
