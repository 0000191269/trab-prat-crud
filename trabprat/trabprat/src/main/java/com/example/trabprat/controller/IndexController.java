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
    public String index() {
        return "index";
    }

    @GetMapping("/rootRedirect")
    public String redirectToRoot() {
        return "redirect:/";
    }

    @GetMapping("/addRedirect")
    public String redirectToAdd() {
        return "redirect:/add";
    }

    @GetMapping("/searchRedirect")
    public String redirectToSearch() {
        return "redirect:/search";
    }

    @GetMapping("/updateRedirect")
    public String updateRedirect() {
        if (Sistema.search) {
            Sistema.search = false;
            return "redirect:/update";
        } else {
            return "redirect:/search";
        }
    }

    @GetMapping("/deleteRedirect")
    public String deleteRedirect() {
        if (Sistema.search) {
            Sistema.search = false;
            return "redirect:/delete";
        } else {
            return "redirect:/search";
        }
    }

    @GetMapping("/delete")
    public String deletePage() {
        Sistema.RemoveFuncionario(Sistema.currentFuncionarioId);
        return "redirect:/";
    }

    @GetMapping("/result")
    public String result(@ModelAttribute SearchId id, Model model) {
        Sistema.search = false;
        Funcionario funcionario = Sistema.getFuncionario(id.getId());
        if (funcionario != null) {
            Sistema.currentFuncionarioId = id.getId();
            Sistema.search = true;
            model.addAttribute("nome", funcionario.getNome());
            model.addAttribute("idade", funcionario.getIdade());
            model.addAttribute("email", funcionario.getEmail());
            model.addAttribute("id", funcionario.getId());
            return "search";
        } else {
            model.addAttribute("notFound", "Funcionário não Encontrado");
            return "search";
        }
    }

    @GetMapping("/search")
    public String userSearch() {
        return "search";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add";
    }

    @GetMapping("/update")
    public String replacePage() {
        return "update";
    }

    @GetMapping("/updateFunc")
    public String updateFunc(@ModelAttribute Funcionario f, Model model) {
        if (f != null) {
            Sistema.getFuncionario(Sistema.currentFuncionarioId).setNome(f.getNome());
            Sistema.getFuncionario(Sistema.currentFuncionarioId).setEmail(f.getEmail());
            Sistema.getFuncionario(Sistema.currentFuncionarioId).setIdade(f.getIdade());
            Sistema.getFuncionario(Sistema.currentFuncionarioId).setSenha(f.getSenha());
        }
        return "index";
    
    }

    @PostMapping("/addFunc")
    public String addFunc(@ModelAttribute Funcionario f, Model model) {
        Sistema.addFuncionario(f);
        return "redirect:/";
    }
}
