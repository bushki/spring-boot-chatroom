package edu.udacity.java.nano.controller;

import edu.udacity.java.nano.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @PostMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response,
                              @ModelAttribute User user) throws IOException {
        System.out.println("inside login controller");
        System.out.println("user name: " + user.getUsername());
        request.getSession().setAttribute("myusername", user.getUsername());

        //return new ModelAndView("redirect:/chat");
        //return new ModelAndView("chat");
        response.sendRedirect("/chat");
    }
}
