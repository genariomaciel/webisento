package br.com.isento.webisento.service;

import br.com.isento.webisento.dto.SolicitacaoDTO;
import br.com.isento.webisento.entity.Solicitacao;
import br.com.isento.webisento.entity.StatusSolicitacao;
import br.com.isento.webisento.repository.SolicitacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitacaoService {

    private final SolicitacaoRepository repository;

    @Transactional
    public SolicitacaoDTO criar(SolicitacaoDTO dto) {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setNomeRequerente(dto.getNomeRequerente());
        solicitacao.setCpf(dto.getCpf());
        solicitacao.setPlacaVeiculo(dto.getPlacaVeiculo());
        solicitacao.setMarcaVeiculo(dto.getMarcaVeiculo());
        solicitacao.setModeloVeiculo(dto.getModeloVeiculo());
        solicitacao.setAnoVeiculo(dto.getAnoVeiculo());
        solicitacao.setTipoVeiculo(dto.getTipoVeiculo());
        solicitacao.setValorVeiculo(dto.getValorVeiculo());
        solicitacao.setObservacoes(dto.getObservacoes());

        Solicitacao salva = repository.save(solicitacao);
        return mapToDTO(salva);
    }

    @Transactional(readOnly = true)
    public SolicitacaoDTO obterPorId(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));
    }

    @Transactional(readOnly = true)
    public List<SolicitacaoDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SolicitacaoDTO> listarPorStatus(StatusSolicitacao status) {
        return repository.findByStatus(status).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public SolicitacaoDTO atualizar(Long id, SolicitacaoDTO dto) {
        Solicitacao solicitacao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        solicitacao.setNomeRequerente(dto.getNomeRequerente());
        solicitacao.setPlacaVeiculo(dto.getPlacaVeiculo());
        solicitacao.setMarcaVeiculo(dto.getMarcaVeiculo());
        solicitacao.setModeloVeiculo(dto.getModeloVeiculo());
        solicitacao.setAnoVeiculo(dto.getAnoVeiculo());
        solicitacao.setTipoVeiculo(dto.getTipoVeiculo());
        solicitacao.setValorVeiculo(dto.getValorVeiculo());
        solicitacao.setStatus(dto.getStatus());
        solicitacao.setObservacoes(dto.getObservacoes());

        Solicitacao atualizada = repository.save(solicitacao);
        return mapToDTO(atualizada);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private SolicitacaoDTO mapToDTO(Solicitacao solicitacao) {
        SolicitacaoDTO dto = new SolicitacaoDTO();
        dto.setId(solicitacao.getId());
        dto.setNomeRequerente(solicitacao.getNomeRequerente());
        dto.setCpf(solicitacao.getCpf());
        dto.setPlacaVeiculo(solicitacao.getPlacaVeiculo());
        dto.setMarcaVeiculo(solicitacao.getMarcaVeiculo());
        dto.setModeloVeiculo(solicitacao.getModeloVeiculo());
        dto.setAnoVeiculo(solicitacao.getAnoVeiculo());
        dto.setTipoVeiculo(solicitacao.getTipoVeiculo());
        dto.setValorVeiculo(solicitacao.getValorVeiculo());
        dto.setStatus(solicitacao.getStatus());
        dto.setObservacoes(solicitacao.getObservacoes());
        dto.setDataCriacao(solicitacao.getDataCriacao());
        dto.setDataAtualizacao(solicitacao.getDataAtualizacao());
        return dto;
    }
}
