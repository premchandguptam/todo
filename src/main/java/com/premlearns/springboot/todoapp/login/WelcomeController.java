package com.premlearns.springboot.todoapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    // RequestParam is the parameters that can be passed along with request to the
    //controller
    //When ever you want to pass values from Controller to jsp we use Model(model map)
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model){
        model.put("name", "Premchand");
      return "welcome" ;
    }


}
