package br.com.cliente.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cliente.api.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
