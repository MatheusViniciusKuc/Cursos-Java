package com.bsoft.login.configurations.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bsoft.login.dao.UsuarioDao;
import com.bsoft.login.dto.UsuarioDto;
import com.bsoft.login.model.Usuario;

@Service
public class ServicoAutenticacao implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioDao.findByEmail(username);

        if (usuario.isPresent()) {
            
            return new UsuarioDto(usuario.get());
        }

        throw new UsernameNotFoundException("Não foi encontrado o usuario");
    }

}
