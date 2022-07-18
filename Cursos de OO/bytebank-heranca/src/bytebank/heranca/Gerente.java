package bytebank.heranca;

public class Gerente extends Funcionario implements Autenticavel {

    private Autenticador autenticador;

    public Gerente() {
        this.autenticador = new Autenticador();
    }

    @Override
    public double getBonificacao() {
        return 150.0;
    }

    @Override
    public void setSenha(int senha) {
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autenticar(int senha) {
        return this.autenticador.autenticar(senha);
    }

}
