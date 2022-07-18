package scr.br.com.bsoft.loja.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import scr.br.com.bsoft.loja.ConnectionFactory;
import scr.br.com.bsoft.loja.DAO.CategoriaDAO;
import scr.br.com.bsoft.loja.model.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController() throws SQLException {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}

	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
