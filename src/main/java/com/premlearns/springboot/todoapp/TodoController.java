package com.premlearns.springboot.todoapp;


import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.naming.Binding;
import java.time.LocalDate;
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
        String username = getLoggedInUsername(model);
        List<Todo> todos =toDoService.findByUsername(username);
        model.addAttribute("todos", todos);

        return "listTodos";
    }



    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public  String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }




    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public  String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }

        String username = getLoggedInUsername(model);
        toDoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),false);

        //we will be redirecting to the list-Todos url to have prepoulated data
        // have this to retrun the listTodo jsp page will have Table without any
        // previous data
        return "redirect:list-todos";
    }


    @RequestMapping("delete-todo")
    public  String deleteTodo(@RequestParam int id){
        //Delete the task using id and redirect to list-todos page
        toDoService.deleleByID(id);

        return "redirect:list-todos";

    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public  String ShowUpdateTodoPage(@RequestParam int id, ModelMap model){
        //Delete the task using id and redirect to list-todos page
        Todo todo = toDoService.findById(id);
        model.addAttribute("todo",todo);
        return "todo";

    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public  String UpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }

        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        toDoService.updateTodo(todo);

        //we will be redirecting to the list-Todos url to have prepoulated data
        // have this to retrun the listTodo jsp page will have Table without any
        // previous data
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication  authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }





}
