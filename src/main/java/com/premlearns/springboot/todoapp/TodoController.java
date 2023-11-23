package com.premlearns.springboot.todoapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    // list-todos

    private ToDoService toDoService;

    public TodoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public  String listAllTodos(ModelMap model){

        List<Todo> todos =toDoService.findByUsername("premchand");
        model.addAttribute("todos", todos);

        return "listTodos";
    }
}
