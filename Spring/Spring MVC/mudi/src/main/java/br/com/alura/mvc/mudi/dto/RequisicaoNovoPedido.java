package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.Pedido;

public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlDoProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlDoProduto() {
        return urlDoProduto;
    }

    public void setUrlDoProduto(String urlDoProduto) {
        this.urlDoProduto = urlDoProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(this.nomeProduto);
        pedido.setUrlDoProduto(this.urlDoProduto);
        pedido.setUrlImagem(this.urlImagem);
        pedido.setDescricao(this.descricao);
        return pedido;
    }

}
