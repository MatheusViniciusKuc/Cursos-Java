package br.com.bsoft.emailjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @Column(name = "id_empresa")
    private Integer id;
    String nome;

    public Empresa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Empresa() {
    }

}
