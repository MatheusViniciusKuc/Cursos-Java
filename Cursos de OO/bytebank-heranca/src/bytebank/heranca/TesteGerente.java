package bytebank.heranca;

public class TesteGerente {

    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        Cliente cliente = new Cliente();
        
        cliente.setSenha(5523);
        
        SistemaInterno si = new SistemaInterno();
        si.autenticar(cliente);
    }
    
}
