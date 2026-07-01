package br.com.isento.webisento.repository;

import br.com.isento.webisento.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByNumeroProcesso(Long numeroProcesso);
    Optional<Servico> findByNumeroProcessoAndSequencia(Long numeroProcesso, Integer sequencia);
    List<Servico> findByNomeContainingIgnoreCase(String nome);
}
