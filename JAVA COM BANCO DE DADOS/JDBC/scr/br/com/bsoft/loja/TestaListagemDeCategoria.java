
package scr.br.com.bsoft.loja;

import java.sql.Connection;

import scr.br.com.bsoft.loja.DAO.CategoriaDAO;
import scr.br.com.bsoft.loja.model.Produto;

public class TestaListagemDeCategoria {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categiaDAO = new CategoriaDAO(connection);
            categiaDAO.listarComProdutos().stream().forEach(ct -> {
                for (Produto produto : ct.getProdutos()) {
                    System.out.println(ct.getNome() + " - " + produto.getNome());
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
