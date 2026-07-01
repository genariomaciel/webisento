package br.com.isento.webisento.repository;

import br.com.isento.webisento.entity.Procurador;
import br.com.isento.webisento.entity.StatusProcurador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcuradorRepository extends JpaRepository<Procurador, Long> {
    Optional<Procurador> findByCpf(String cpf);
    List<Procurador> findByStatus(StatusProcurador status);
    List<Procurador> findByNomeContainingIgnoreCase(String nome);
}
