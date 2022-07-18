package bytebank.heranca;

public class TesteReferencia {
    
    public static void main(String[] args) {
        Gerente g1 = new Gerente();
        g1.setNome("Marcos");
        g1.setSalario(5000.0);
        
        EditorVideo ev = new EditorVideo();
        ev.setSalario(2500.0);
        
        Desinger d = new Desinger();
        d.setSalario(5120.0);
        
        ControleBonificacao controle = new ControleBonificacao();
        controle.registra(g1);
        controle.registra(ev);
        controle.registra(d);
        
        System.out. println(controle.getSoma());
        
    }
}
