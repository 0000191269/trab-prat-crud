package com.example.trabprat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.trabprat.model.User;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) {
        System.out.println(user.toString());
        model.addAttribute("username", user.getName());
        model.addAttribute("password", user.getPasswd());
        return "welcome";
    }
}
