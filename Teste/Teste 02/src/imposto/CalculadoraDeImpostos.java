package src.imposto;

import java.math.BigDecimal;

import src.orcamento.Orcamento;

public class CalculadoraDeImpostos {

    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }
}
