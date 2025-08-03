package io.github.cursodsousa.icompras.clientes.service;

import io.github.cursodsousa.icompras.clientes.model.Cliente;
import io.github.cursodsousa.icompras.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public Optional<Cliente> obterPorCodigo(Long codigo){
        return repository.findById(codigo);
    }

    public void deletar(Cliente cliente) {
        cliente.setAtivo(false);
        repository.save(cliente);
    }
}
