package modulos;

public class Controle {

    public static void main(String[] args) {
        /*Conta conta1 = new Conta();
        conta1.saldo = 200;
        System.out.println("O valor da conta e de R$" + conta1.saldo+ " na conta 1.");
        conta1.saldo += 100;
        System.out.println("O valor da conta e de R$" + conta1.saldo+ " na conta 1.");
        
        Conta conta2 = new Conta();
        conta2.saldo = 50;
        System.out.println("O valor da conta e de R$" + conta2.saldo+ " na conta 2.");*/
        
        Conta conta = new Conta(1155, 55115);
        conta.deposita(500);
        System.out.println(conta.getSaldo());
        Conta conta2 = new Conta(5165, 4644);
        System.out.println("1: "+conta.getSaldo());
        System.out.println("2: "+conta2.getSaldo());
        conta.transfere(500, conta2);
        System.out.println("1: "+conta.getSaldo());
        System.out.println("2: "+conta2.getSaldo());
        Cliente paulo = new Cliente();
        paulo.nome = "Paulo";
        paulo.cpf = "111.111.111-25";
        paulo.profissao = "Programador";
        conta.setTitular(paulo);
        System.out.println(conta.getTitular().nome);
        Conta conta3 = new Conta(5165, 46445);
        
        System.out.println(Conta.getTotal());
    }
}
