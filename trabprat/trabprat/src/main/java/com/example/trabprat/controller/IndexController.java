package com.example.trabprat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.trabprat.model.Funcionario;
import com.example.trabprat.model.SearchId;
import com.example.trabprat.model.Sistema;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/add")
    public String userAdd(@ModelAttribute Funcionario f, Model model) {
        Sistema.addFuncionario(f);
        return "index";
    }

    @GetMapping("/buscar")
    public String userSearch(@ModelAttribute SearchId id, Model model) {
        Sistema.addFuncionario(new Funcionario("erick", "321", "gamil@email.com", 18));
        Sistema.addFuncionario(new Funcionario("pedro", "abc", "email@email.com", 18));
        Funcionario f2 = Sistema.getFuncionario(id.getId());
        model.addAttribute("nome", f2.getNome());
        model.addAttribute("idade", f2.getIdade());
        model.addAttribute("email", f2.getEmail());
        model.addAttribute("id", f2.getId());
        return "buscar";
    }
}
