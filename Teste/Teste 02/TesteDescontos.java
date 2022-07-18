import java.math.BigDecimal;

import src.desconto.CalculadoraDeDesconto;
import src.orcamento.Orcamento;

public class TesteDescontos {
    public static void main(String[] args) {
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
        System.out.println(calculadora.calcular(new Orcamento(new BigDecimal("200"), 4)));
        System.out.println(calculadora.calcular(new Orcamento(new BigDecimal("1000"), 1)));
        System.out.println(calculadora.calcular(new Orcamento(new BigDecimal("1000"), 9)));
    }
}
