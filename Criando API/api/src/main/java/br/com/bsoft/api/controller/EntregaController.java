package br.com.bsoft.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bsoft.api.domain.model.Entrega;
import br.com.bsoft.api.domain.repository.EntregaRepository;
import br.com.bsoft.api.domain.service.SolitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private SolitacaoEntregaService solitacaoEntregaService;
    @Autowired
    private EntregaRepository entregaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
        return solitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaID}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long entregaID) {
        return entregaRepository.findById(entregaID).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
