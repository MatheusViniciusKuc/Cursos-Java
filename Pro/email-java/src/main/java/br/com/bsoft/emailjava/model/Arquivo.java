package br.com.bsoft.emailjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "arquivos")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arquivo")
    private int id;
    private String nomeArquivo;
    @OneToOne
    private Empresa empresa;
    @OneToOne
    private Email email;

    public Arquivo(int id, String nomeArquivo, Empresa empresa, Email email) {
        this.id = id;
        this.nomeArquivo = nomeArquivo;
        this.empresa = empresa;
        this.email = email;
    }

    public Arquivo() {
    }

}
