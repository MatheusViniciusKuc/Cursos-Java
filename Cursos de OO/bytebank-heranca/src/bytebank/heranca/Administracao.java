package bytebank.heranca;

public class Administracao extends Funcionario implements Autenticavel{

    private Autenticador autenticador;

    public Administracao() {
        this.autenticador = new Autenticador();
    }
    
    @Override
    public double getBonificacao() {
        return 50;
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
