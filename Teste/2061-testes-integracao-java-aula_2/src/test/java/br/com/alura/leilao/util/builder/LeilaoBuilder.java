package br.com.alura.leilao.util.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

public class LeilaoBuilder {

    private String nome;
    private BigDecimal valorInicial;
    private LocalDate data;
    private Usuario usuario;

    
    /** 
     * @param nome
     * @return LeilaoBuilder
     */
    public LeilaoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    
    /** 
     * @param data
     * @return LeilaoBuilder
     */
    public LeilaoBuilder comData(LocalDate data) {
        this.data = data;
        return this;
    }

    
    /** 
     * @param valor
     * @return LeilaoBuilder
     */
    public LeilaoBuilder comValorInicial(String valor) {
        this.valorInicial = new BigDecimal(valor);
        return this;
    }

    
    /** 
     * @param usuario
     * @return LeilaoBuilder
     */
    public LeilaoBuilder comUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    
    /** 
     * @return Leilao
     */
    public Leilao criar() {
        return new Leilao(nome, valorInicial, data, usuario);
    }

}
