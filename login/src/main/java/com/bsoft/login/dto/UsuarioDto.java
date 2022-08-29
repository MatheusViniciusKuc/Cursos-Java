package com.bsoft.login.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bsoft.login.model.Usuario;

import lombok.Getter;

@Getter
public class UsuarioDto implements UserDetails {

    private String email;
    private String senha;
    private List<PerfilDto> perfis;

    public UsuarioDto(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        perfis = new ArrayList<>();
        perfis.add(definirPerfil(usuario.getAdministrador()));
    }

    private PerfilDto definirPerfil(int administrador) {

        PerfilDto perfilDto = new PerfilDto();
        if (administrador == 1) {
            perfilDto.setNome("ADM");
        }

        return perfilDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
