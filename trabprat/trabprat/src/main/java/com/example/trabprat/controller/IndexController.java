package com.example.trabprat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.trabprat.model.Funcionario;
import com.example.trabprat.model.Sistema;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        Sistema.addFuncionario(new Funcionario("pedro", "abc", "email@email.com", 18));
        Sistema.addFuncionario(new Funcionario("erick", "321", "gamil@email.com", 18));
        model.addAttribute("num", Sistema.funcionarios.size());
        for (Funcionario f : Sistema.funcionarios) {
            model.addAttribute("nome%d".formatted(f.getId()), f.getNome());
            model.addAttribute("email%d".formatted(f.getId()), f.getEmail());
            model.addAttribute("id%d".formatted(f.getId()), f.getId());
            model.addAttribute("idade%d".formatted(f.getId()), f.getIdade());
        }

        return "index";
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute Funcionario f, Model model) {
        Sistema.addFuncionario(f);
        return "index";
    }
}
