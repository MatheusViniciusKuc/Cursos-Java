package br.com.alura.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedido {

    private String cliente;
    private BigDecimal valorOrcamento;
    private int qtdItens;

    public GeraPedido(String cliente, BigDecimal valorOrcamento, int qtdItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.qtdItens = qtdItens;
    }

    public void executa() {
        Orcamento orcamento = new Orcamento(this.valorOrcamento, this.qtdItens);
        Pedido pedido = new Pedido(cliente, LocalDateTime.now(), orcamento);
        System.out.println("Salvar pedido no Banco De Dados");
        System.out.println("Enviar email com dados do novo pedido");
    }
}
