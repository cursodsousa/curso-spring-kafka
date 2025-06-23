package io.github.cursodsousa.icompras.clientes.repository;

import io.github.cursodsousa.icompras.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
