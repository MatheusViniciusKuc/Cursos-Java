package br.com.bsoft.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bsoft.api.domain.model.Cliente;
import br.com.bsoft.api.domain.repository.ClienteRepository;
import br.com.bsoft.api.domain.service.CatalogoClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return catalogoClienteService.salvar(cliente);
    }

    @GetMapping("/{clienteID}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {
        return clienteRepository.findById(clienteID).map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteID, @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteID);
        cliente = catalogoClienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteID}")
    public ResponseEntity<Void> deletar(@PathVariable Long clienteID) {
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        catalogoClienteService.excluir(clienteID);
        return ResponseEntity.noContent().build();

    }
}
