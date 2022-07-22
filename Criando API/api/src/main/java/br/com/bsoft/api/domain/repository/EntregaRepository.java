package br.com.bsoft.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bsoft.api.domain.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
