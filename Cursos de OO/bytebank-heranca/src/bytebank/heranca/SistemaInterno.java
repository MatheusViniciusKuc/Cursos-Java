package bytebank.heranca;

public class SistemaInterno {
    
    private int senha = 2222;
    
    public void autenticar(Autenticavel fa){
        if(fa.autenticar(this.senha)){
            System.out.println("Pode entrar no Sistema!");
        } else {
         System.out.println("Não pode entrar no Sistema!");   
        }
    }
    
}
