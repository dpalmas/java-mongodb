package br.com.alura.escolalura.escolalura.controllers;

import br.com.alura.escolalura.escolalura.models.Aluno;
import br.com.alura.escolalura.escolalura.repositorys.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController 
{
    @Autowired
    private AlunoRepository repository;

    @GetMapping("/aluno/cadastrar")
    public String cadastrar(Model model) 
    {
        model.addAttribute("aluno", new Aluno());
        return "/aluno/cadastrar";
    }

    @PostMapping("/aluno/salvar")
    public String salvar(@ModelAttribute Aluno aluno) 
    {
        System.out.println("Aluno para salvar: " + aluno);
        repository.salvar(aluno);
        return "redirect:/";
    }
}
