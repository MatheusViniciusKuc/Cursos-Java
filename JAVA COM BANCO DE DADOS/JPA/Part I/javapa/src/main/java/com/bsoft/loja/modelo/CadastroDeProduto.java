package com.bsoft.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.bsoft.loja.dao.CategoriaDAO;
import com.bsoft.loja.dao.ProdutoDAO;
import com.bsoft.loja.util.JPAUtil;

public class CadastroDeProduto {

    public void cadastro() {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Categoria celulares = new Categoria("celulares");
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        categoriaDAO.cadastrar(celulares);
        Produto celular = new Produto("Xiaomi Redmi", "Um possivel celular", new BigDecimal("1200"),
                celulares);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
