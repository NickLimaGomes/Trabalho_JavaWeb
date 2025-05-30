package com.jw.trabalho.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class LivrosDAO {
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirLivro(Livros l) {
		String qry = "INSERT INTO livros(titulo, autor, ano_publicacao, genero)"
				+ " VALUES (?,?,?,?)";
		Object[] parametros = new Object[4];
		parametros[0] = l.getTitulo();
		parametros[1] = l.getAutor();
		parametros[2] = l.getAno();
		parametros[3] = l.getGenero();
		jdbc.update(qry, parametros);
	}
	
	public List<Livros> listarLivros() {
		String qry = "SELECT * FROM livros";
		return jdbc.query(qry, (rs, rowNum) -> {
		    Livros l = new Livros();
		    l.setId(rs.getLong("id"));
		    l.setTitulo(rs.getString("titulo"));
		    l.setAutor(rs.getString("autor"));
		    l.setAno(rs.getInt("ano_publicacao"));
		    l.setGenero(rs.getString("genero"));
		    return l;
		});
	}
	
	public void removerLivro(long idLivro) {
		String qry = "DELETE FROM livros WHERE id = ?";
		jdbc.update(qry, idLivro);
	}

	public void updateLivro(Livros l) {
		String qry = "UPDATE livros SET titulo = ?, autor = ?, ano_publicacao = ?, genero = ? WHERE id = ?";
		Object[] parametros = 
		new Object[] {
			l.getTitulo(),
			l.getAutor(),
			l.getAno(),
			l.getGenero(),
			l.getId()};
		jdbc.update(qry, parametros);
	}

	public Livros pesquisarPorId(long idLivro) {
		String qry = "SELECT * FROM livros where id = ?";
		List<Livros> lstLivros = jdbc.query(qry, (rs, rowNum) -> {
		    Livros l = new Livros();
		    l.setId(rs.getLong("id"));
		    l.setTitulo(rs.getString("titulo"));
		    l.setAutor(rs.getString("autor"));
		    l.setAno(rs.getInt("ano_publicacao"));
		    l.setGenero(rs.getString("genero"));
		    return l;
		}, idLivro);
		return lstLivros.get(0);
	}
}
