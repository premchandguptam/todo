package com.premlearns.springboot.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    public boolean authenticate(String username, String password){

        boolean isValidUserName = username.equalsIgnoreCase("premchand");
        boolean isValidPassword = password.equalsIgnoreCase("qwerty");
        return isValidUserName & isValidPassword;
    }

}
