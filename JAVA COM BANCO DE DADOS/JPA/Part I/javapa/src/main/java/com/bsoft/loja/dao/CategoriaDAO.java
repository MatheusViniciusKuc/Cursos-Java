package com.bsoft.loja.dao;

import javax.persistence.EntityManager;

import com.bsoft.loja.modelo.Categoria;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }
}
