import java.math.BigDecimal;

import src.imposto.CalculadoraDeImpostos;
import src.imposto.ISS;
import src.orcamento.Orcamento;

public class TesteImpostos {
    public static void main(String[] args) {
        CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
        System.out.println(calculadora.calcular(new Orcamento(new BigDecimal("300"), 2), new ISS()));
    } 
}
 