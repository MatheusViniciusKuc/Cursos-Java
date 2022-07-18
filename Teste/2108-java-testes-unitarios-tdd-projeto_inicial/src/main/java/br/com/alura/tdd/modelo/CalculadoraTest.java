package br.com.alura.tdd.modelo;

public class CalculadoraTest {
    
    @Test
    public void deveriaSomarDoisNumerosPositivos() {
        Calculadora calc = new Calculadora();
        int soma = calc.somar(3, 7);
    }
}
