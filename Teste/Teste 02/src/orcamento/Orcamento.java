package src.orcamento;

import java.math.BigDecimal;

import src.orcamento.situacao.Finalizado;
import src.orcamento.situacao.SituacaoOrcamento;

public class Orcamento {

    private BigDecimal valor;
    private int qtdItens;
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, int qtdItens) {
        this.valor = valor;
        this.qtdItens = qtdItens;
    }

    public void aplicarDescontoExtra() {
        BigDecimal valorDesconto = BigDecimal.ZERO;
        if (situacao.equals("EM_ANALISE")) {
            valorDesconto = new BigDecimal("0.05");
        } else if (situacao.equals("APROVADO")) {
            valorDesconto = new BigDecimal("0.02");
        }
        this.valor = this.valor.subtract(valorDesconto);
    }

    public void aprovar() {

    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public void setSituacao(Finalizado finalizado) {
    }
}
