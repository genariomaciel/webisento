package br.com.isento.webisento.repository;

import br.com.isento.webisento.entity.Processo;
import br.com.isento.webisento.entity.StatusProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
    Optional<Processo> findByNumeroProcesso(Long numeroProcesso);
    List<Processo> findByCodigoRequerente(Long codigoRequerente);
    List<Processo> findByStatus(StatusProcesso status);
    List<Processo> findByCodigoPerito(Long codigoPerito);
}
