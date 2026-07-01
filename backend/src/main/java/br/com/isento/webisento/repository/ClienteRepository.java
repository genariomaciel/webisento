package br.com.isento.webisento.repository;

import br.com.isento.webisento.entity.Cliente;
import br.com.isento.webisento.entity.StatusCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
    List<Cliente> findByStatus(StatusCliente status);
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    List<Cliente> findByCidadeContainingIgnoreCase(String cidade);
}
