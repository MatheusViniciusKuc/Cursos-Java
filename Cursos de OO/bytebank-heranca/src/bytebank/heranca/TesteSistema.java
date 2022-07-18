package bytebank.heranca;

public class TesteSistema {
    public static void main(String[] args) {
        
        Gerente g = new Gerente();
        //g.setSenha(2222);
        
        Administracao adm = new Administracao();
        //adm.setSenha(2222);
        
        Desinger d = new Desinger();
        
        SistemaInterno si = new SistemaInterno();
        //si.autenticar(g);
        //si.autenticar(adm);
    }
}
