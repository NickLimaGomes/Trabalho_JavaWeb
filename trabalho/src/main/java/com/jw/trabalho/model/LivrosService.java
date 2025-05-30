package com.jw.trabalho.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivrosService {
	@Autowired
	LivrosDAO dao;
	
	public void inserirLivro(Livros l) {
		if(l.getId() == 0)
			dao.inserirLivro(l);
		else
			dao.updateLivro(l);
	}
	
	public List<Livros> listarLivros(){
		return dao.listarLivros();
	}
	
	public void removerLivro(long idLivro) {
		dao.removerLivro(idLivro);
	}

	public Livros pesquisarLivro(long idLivro) {
		return dao.pesquisarPorId(idLivro);
	}
}
