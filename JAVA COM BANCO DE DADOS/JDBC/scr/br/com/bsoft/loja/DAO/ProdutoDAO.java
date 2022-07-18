package scr.br.com.bsoft.loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import scr.br.com.bsoft.loja.model.Categoria;
import scr.br.com.bsoft.loja.model.Produto;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
        try (PreparedStatement ptm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ptm.setString(1, produto.getNome());
            ptm.setString(2, produto.getDescricao());
            ptm.execute();
            try (ResultSet rst = ptm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<Produto>();
        try (PreparedStatement ptm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO")) {
            ptm.execute();
            try (ResultSet rst = ptm.getResultSet()) {
                while (rst.next()) {
                    Produto p = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(p);
                }
            }
        } catch (Exception e) {
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria ct) {
        List<Produto> produtos = new ArrayList<Produto>();
        try (PreparedStatement ptm = connection
                .prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?")) {
            ptm.setInt(1, ct.getId());
            ptm.execute();
            try (ResultSet rst = ptm.getResultSet()) {
                while (rst.next()) {
                    Produto p = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(p);
                }
            }
        } catch (Exception e) {
        }
        return produtos;
    }

    public void deletar(Integer id) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(String nome, String descricao, Integer id) {
        try (PreparedStatement stm = connection
                .prepareStatement("UPDATE PRODUTO P SET P.NOME = ?, P.DESCRICAO = ? WHERE ID = ?")) {
            stm.setString(1, nome);
            stm.setString(2, descricao);
            stm.setInt(3, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
