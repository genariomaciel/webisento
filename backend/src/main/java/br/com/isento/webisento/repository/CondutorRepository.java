package br.com.isento.webisento.repository;

import br.com.isento.webisento.entity.Condutor;
import br.com.isento.webisento.entity.StatusCondutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {
    Optional<Condutor> findByCpf(String cpf);
    List<Condutor> findByNumeroProcesso(Long numeroProcesso);
    List<Condutor> findByStatus(StatusCondutor status);
    List<Condutor> findByNomeContainingIgnoreCase(String nome);
}
