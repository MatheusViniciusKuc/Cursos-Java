package com.bsoft.login.dto;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDto implements GrantedAuthority {

    private String nome;

    public PerfilDto() {
        this.nome = "USER";
    }

    @Override
    public String getAuthority() {
        return this.nome;
    }
}
