package com.bsoft.loja.testes;

import java.util.List;

import javax.persistence.EntityManager;

import com.bsoft.loja.dao.ProdutoDAO;
import com.bsoft.loja.modelo.CadastroDeProduto;
import com.bsoft.loja.modelo.Produto;
import com.bsoft.loja.util.JPAUtil;

public class Cadastro {
    public static void main(String[] args) {
        CadastroDeProduto cdp = new CadastroDeProduto();
        cdp.cadastro();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        //Produto p = produtoDAO.buscarPorId(1l);
        List<Produto> buscarTodos = produtoDAO.buscarPorNome("Xiaomi Redmi");
        buscarTodos.forEach(p2 -> System.out.println(p2.getNome()));
    }
}
