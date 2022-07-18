package src.desconto;

import java.math.BigDecimal;

import src.orcamento.Orcamento;

public class DescontoParaValor extends Desconto {

    public DescontoParaValor(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }
}
