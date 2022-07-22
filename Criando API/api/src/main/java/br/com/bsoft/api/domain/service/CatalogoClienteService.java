package br.com.bsoft.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bsoft.api.domain.exception.NegocioException;
import br.com.bsoft.api.domain.model.Cliente;
import br.com.bsoft.api.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteID) {
        return clienteRepository.findById(clienteID)
                .orElseThrow(() -> new NegocioException("Cliente não Encontrado!"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteID) {
        clienteRepository.deleteById(clienteID);
    }
}
