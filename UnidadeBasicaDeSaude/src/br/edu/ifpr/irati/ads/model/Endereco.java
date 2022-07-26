package br.edu.ifpr.irati.ads.model;

public class Endereco {

    private String estado;
    private String logradouro;
    private String bairro;
    private String latitude;
    private String longitude;

    public Endereco() {
    }

    public Endereco(String estado, String logradouro, String bairro, String latitude, String longitude) {
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getEstado() {
        return estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
