package br.com.bsoft.api.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bsoft.api.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);
}
