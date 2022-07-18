package src.imposto;

import java.math.BigDecimal;

import src.orcamento.Orcamento;

public class ICMS implements Imposto{
    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}
