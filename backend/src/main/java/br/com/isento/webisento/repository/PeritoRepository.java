package br.com.isento.webisento.repository;

import br.com.isento.webisento.entity.Perito;
import br.com.isento.webisento.entity.StatusPerito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeritoRepository extends JpaRepository<Perito, Long> {
    Optional<Perito> findByCpfCnpj(String cpfCnpj);
    List<Perito> findByStatus(StatusPerito status);
    List<Perito> findByNomeContainingIgnoreCase(String nome);
    List<Perito> findByTipoPessoa(Integer tipoPessoa);
}
