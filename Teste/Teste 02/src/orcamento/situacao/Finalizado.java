package src.orcamento.situacao;

import java.math.BigDecimal;

public class Finalizado extends SituacaoOrcamento {
    
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.02"));
    }

    public void finalizado(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
