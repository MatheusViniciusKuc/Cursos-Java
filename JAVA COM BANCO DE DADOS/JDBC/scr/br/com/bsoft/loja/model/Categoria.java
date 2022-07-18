package scr.br.com.bsoft.loja.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Integer id;
    private String nome;
    private List<Produto> produtos;

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        produtos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
