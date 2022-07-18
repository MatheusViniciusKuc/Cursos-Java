package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteSaca {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente(123, 321);

        conta.deposita(200);
        try {
            conta.saca(250);
        } catch (SaldoInsuficienteException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(conta.getSaldo());
    }
}
