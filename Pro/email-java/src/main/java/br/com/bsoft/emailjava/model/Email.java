package br.com.bsoft.emailjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "emails")
public class Email {

    @Id
    @Column(name = "id_email")
    private Integer id;
    private String email;
    private String password;
    @OneToOne
    private Empresa empresa;

    public Email(Integer id, String email, String password, Empresa empresa) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.empresa = empresa;
    }

    public Email() {
    }

}
