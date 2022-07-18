package src.imposto;

import java.math.BigDecimal;

import src.orcamento.Orcamento;

public interface Imposto {

    BigDecimal calcular(Orcamento orcamento);

}
