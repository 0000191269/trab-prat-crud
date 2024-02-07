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
    public String replaceRedirect() {
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
        return "deleted";
    }

    @GetMapping("/result")
    public String result(@ModelAttribute SearchId id, Model model) {
        Sistema.search = false;
        Sistema.addFuncionario(new Funcionario("erick", "321", "gamil@email.com", 18));
        Sistema.addFuncionario(new Funcionario("pedro", "abc", "email@email.com", 18));
        Funcionario funcionario = Sistema.getFuncionario(id.getId());
        if (funcionario != null) {
            Sistema.search = true;
            model.addAttribute("nome", funcionario.getNome());
            model.addAttribute("idade", funcionario.getIdade());
            model.addAttribute("email", funcionario.getEmail());
            model.addAttribute("id", funcionario.getId());
            return "search";
        } else {
            model.addAttribute("notFound", "funcionario nao encontrado");
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
}
