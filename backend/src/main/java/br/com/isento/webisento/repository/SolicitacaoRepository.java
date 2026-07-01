package br.com.isento.webisento.repository;

import br.com.isento.webisento.entity.Solicitacao;
import br.com.isento.webisento.entity.StatusSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    Optional<Solicitacao> findByCpf(String cpf);
    List<Solicitacao> findByStatus(StatusSolicitacao status);
    List<Solicitacao> findByNomeRequerente(String nomeRequerente);
}
