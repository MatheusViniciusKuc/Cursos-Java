package br.edu.ifpr.irati.ads.model;

public class UnidadesDeSaude {

    private String cnes;
    private String ibge;
    private String nome;
    private Endereco endereco;

    public UnidadesDeSaude() {
    }

    public UnidadesDeSaude(String cnes, String ibge, String nome, Endereco endereco) {
        this.cnes = cnes;
        this.ibge = ibge;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getCnes() {
        return cnes;
    }

    public String getIbge() {
        return ibge;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

}
