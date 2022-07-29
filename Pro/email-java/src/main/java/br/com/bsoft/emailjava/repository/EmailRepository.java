package br.com.bsoft.emailjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bsoft.emailjava.model.Email;

public interface EmailRepository extends JpaRepository<Email, Integer>{
    
}
