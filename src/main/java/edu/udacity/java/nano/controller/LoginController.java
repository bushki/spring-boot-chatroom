package edu.udacity.java.nano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("login")
    public void login()  {
        System.out.println("inside login controller");
    }
}
