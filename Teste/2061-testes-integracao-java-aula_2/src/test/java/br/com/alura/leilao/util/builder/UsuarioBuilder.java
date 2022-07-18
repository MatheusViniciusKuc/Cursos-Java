package br.com.alura.leilao.util.builder;

import br.com.alura.leilao.model.Usuario;

public class UsuarioBuilder {

    private String nome;
    private String email;
    private String senha;

    
    /** 
     * @param nome
     * @return UsuarioBuilder
     */
    public UsuarioBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    
    /** 
     * @param string
     * @return UsuarioBuilder
     */
    public UsuarioBuilder comEmail(String string) {
        this.email = string;
        return this;
    }

    
    /** 
     * @param string
     * @return UsuarioBuilder
     */
    public UsuarioBuilder comSenha(String string) {
        this.senha = string;
        return this;
    }

    
    /** 
     * @return Usuario
     */
    public Usuario criar() {
        return new Usuario(nome, email, senha);
    }
}
