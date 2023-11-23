package com.premlearns.springboot.todoapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authenticationService;
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }




    // RequestParam is the parameters that can be passed along with request to the
    //controller
    //When ever you want to pass values from Controller to jsp we use Model(model map)
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String Login(){

      return "login" ;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String welcomepage(@RequestParam String name, @RequestParam String password, ModelMap model){


        if (authenticationService.authenticate(name,password)){

            model.put("name",name);

            //Authentication
            //Name-premchand
            //password - qwerty

            return "welcome" ;
        }


        model.put("errorMessage", "Invalid Credentials");
        return "login";



    }
}
