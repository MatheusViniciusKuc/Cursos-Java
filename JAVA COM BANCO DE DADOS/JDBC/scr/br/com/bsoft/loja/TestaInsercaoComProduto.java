package scr.br.com.bsoft.loja;

import java.sql.Connection;
import java.util.List;

import scr.br.com.bsoft.loja.DAO.ProdutoDAO;
import scr.br.com.bsoft.loja.model.Produto;

public class TestaInsercaoComProduto {
    public static void main(String[] args) {
        Produto comoda = new Produto("VideoGame", "X-BOX");

        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO pp = new ProdutoDAO(connection);
            pp.salvar(comoda);
            List<Produto> produtos = pp.listar();
            produtos.stream().forEach(p -> System.out.println(p));
        } catch (Exception e) {
        }
    }
}
