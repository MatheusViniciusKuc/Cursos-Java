package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataDaEntrega;
    private String urlDoProduto;
    private String urlImagem;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Pedido(String nomeProduto, BigDecimal valorNegociado, LocalDate dataDaEntrega, String urlDoProduto,
            String urlImagem, String descricao, StatusPedido status, User user) {
        this.nomeProduto = nomeProduto;
        this.valorNegociado = valorNegociado;
        this.dataDaEntrega = dataDaEntrega;
        this.urlDoProduto = urlDoProduto;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
        this.status = status;
        this.user = user;
    }

    public Pedido() {
    }

    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public String getUrlDoProduto() {
        return urlDoProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setUrlDoProduto(String urlDoProduto) {
        this.urlDoProduto = urlDoProduto;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
    }
}
