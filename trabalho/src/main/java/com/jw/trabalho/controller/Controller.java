package com.jw.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jw.trabalho.model.Livros;
import com.jw.trabalho.model.LivrosService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private LivrosService service;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("livros", service.listarLivros());
		model.addAttribute("livro", new Livros());
		return "index";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarLivro(Model model, @ModelAttribute Livros livro) {
		service.inserirLivro(livro);
		return "redirect:";
	}
	
	@PostMapping("/remover")
	public String removerLivro(@RequestParam long idLivro) {
		service.removerLivro(idLivro);
		return "redirect:";
	}
	
	@PostMapping("/editar")
	public String editarLivro(Model model, @RequestParam long idLivro) {
		Livros livro = service.pesquisarLivro(idLivro);
		model.addAttribute("livros", service.listarLivros());
		model.addAttribute("livro", livro);
		return "index";
	}
}
