package src.desconto;

import java.math.BigDecimal;

import src.orcamento.Orcamento;

public class DescontoParaItens extends Desconto {

    public DescontoParaItens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQtdItens() > 5;
    }
}
