package br.com.bsoft.api.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bsoft.api.domain.model.Cliente;
import br.com.bsoft.api.domain.model.Entrega;
import br.com.bsoft.api.domain.model.StatusEntrega;
import br.com.bsoft.api.domain.repository.EntregaRepository;

@Service
public class SolitacaoEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }
}
