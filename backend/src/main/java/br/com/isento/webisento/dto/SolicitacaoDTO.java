package br.com.isento.webisento.dto;

import br.com.isento.webisento.entity.StatusSolicitacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoDTO {
    private Long id;
    private String nomeRequerente;
    private String cpf;
    private String placaVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private Integer anoVeiculo;
    private String tipoVeiculo;
    private Double valorVeiculo;
    private StatusSolicitacao status;
    private String observacoes;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
