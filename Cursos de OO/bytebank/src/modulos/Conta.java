package modulos;

public class Conta {

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total;

    public Conta(int agencia, int numero) {
        Conta.total++;
        System.out.println("O total de contas e de: "+total);
        this.agencia = agencia;
        this.numero = numero;
    }

    public void deposita(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    public boolean saca(double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            destino.deposita(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    
    public static int getTotal(){
        return Conta.total;
    }
}
