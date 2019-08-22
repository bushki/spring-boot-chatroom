package edu.udacity.java.nano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public ModelAndView chat(HttpServletRequest request) {
        System.out.println("inside chat controller");
        System.out.println("userName: "+ request.getSession().getAttribute("myusername").toString());
        return new ModelAndView("chat");
    }
}
