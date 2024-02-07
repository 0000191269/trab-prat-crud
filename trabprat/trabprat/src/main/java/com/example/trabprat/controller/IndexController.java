package com.example.trabprat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.trabprat.model.Funcionario;
import com.example.trabprat.model.SearchId;
import com.example.trabprat.model.Sistema;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addRedirect")
    public String redirectToAdd() {
        return "redirect:/add";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add";
    }

    @GetMapping("/searchRedirect")
    public String redirectToSearch() {
        return "redirect:/search";
    }

    @GetMapping("/result")
    public String result(@ModelAttribute SearchId id, Model model) {
        Sistema.addFuncionario(new Funcionario("erick", "321", "gamil@email.com", 18));
        Sistema.addFuncionario(new Funcionario("pedro", "abc", "email@email.com", 18));
        Funcionario f2 = Sistema.getFuncionario(id.getId());
        model.addAttribute("nome", f2.getNome());
        model.addAttribute("idade", f2.getIdade());
        model.addAttribute("email", f2.getEmail());
        model.addAttribute("id", f2.getId());
        return "result";
    }

    @GetMapping("/search")
    public String userSearch() {
        return "search";
    }
}
