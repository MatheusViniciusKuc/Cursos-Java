package br.com.bsoft.emailjava.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bsoft.emailjava.model.Email;
import br.com.bsoft.emailjava.repository.EmailRepository;

@RestController
@RequestMapping(("empresa"))
public class TesteJPA {

    @Autowired
    EmailRepository empresaRepository;

    @GetMapping
    public List<Email> oo() {
        return empresaRepository.findAll();
    }

}
