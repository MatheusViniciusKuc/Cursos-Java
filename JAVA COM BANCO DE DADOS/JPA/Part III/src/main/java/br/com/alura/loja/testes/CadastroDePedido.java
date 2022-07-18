package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(1l);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();
        Cliente cliente = clienteDAO.buscarPorId(1l);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, produto, pedido));
        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);
        em.getTransaction().commit();
        em.close();
    }

    private static void popularDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Cliente cliente = new Cliente("João", "111.222.333-45");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDAO.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
