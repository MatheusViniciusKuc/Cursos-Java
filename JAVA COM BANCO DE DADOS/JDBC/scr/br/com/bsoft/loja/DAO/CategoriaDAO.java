package scr.br.com.bsoft.loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import scr.br.com.bsoft.loja.model.Categoria;
import scr.br.com.bsoft.loja.model.Produto;

public class CategoriaDAO {

    private Connection connection;
    List<Categoria> categorias;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() {
        categorias = new ArrayList<>();
        String sql = "SELECT ID, NOME FROM CATEGORIA";
        try (PreparedStatement ptm = connection.prepareStatement(sql)) {
            ptm.execute();
            try (ResultSet rst = ptm.getResultSet()) {
                while (rst.next()) {
                    Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                    categorias.add(categoria);
                }
            }
        } catch (Exception e) {
        }
        return categorias;
    }

    public List<Categoria> listarComProdutos() {
        Categoria ultima = null;
        categorias = new ArrayList<>();
        String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";
        try (PreparedStatement ptm = connection.prepareStatement(sql)) {
            ptm.execute();
            try (ResultSet rst = ptm.getResultSet()) {
                while (rst.next()) {
                    if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        ultima = categoria;
                        categorias.add(categoria);
                    }
                    Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                    ultima.adicionar(produto);
                }
            }
        } catch (Exception e) {
        }
        return categorias;
    }

}
