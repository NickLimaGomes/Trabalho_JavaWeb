package com.jw.trabalho.model;

public class Livros {

	private long id;
	private String autor;
	private String titulo;
	private Integer ano;
	private String genero;
	
	public Livros() {
		
	}
	
	public Livros(String autor, String titulo, Integer ano, String genero) {
		this.autor = autor;
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
