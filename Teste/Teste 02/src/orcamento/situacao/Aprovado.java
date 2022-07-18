package src.orcamento.situacao;

import java.math.BigDecimal;

import src.orcamento.Orcamento;

public class Aprovado extends SituacaoOrcamento{

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.02"));
    }

    public void finalizado(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
