package edu.udacity.java.nano.controller;

import edu.udacity.java.nano.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @PostMapping("login")
    public void login(@ModelAttribute User user)  {
        System.out.println("inside login controller");
    }
}
