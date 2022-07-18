package src.desconto;

import java.math.BigDecimal;

import src.orcamento.Orcamento;

public class CalculadoraDeDesconto {

    public BigDecimal calcular(Orcamento orcamento) {
        Desconto desconto = new DescontoParaItens(new DescontoParaValor(new SemDesconto()));
        return desconto.calcular(orcamento);
    }

}
