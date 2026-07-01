package br.com.isento.webisento.dto;

import br.com.isento.webisento.entity.StatusProcesso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessoDTO {
    private Long id;
    private Long numeroProcesso;
    private Long codigoRequerente;
    private Integer codigoTipoRequerente;
    private Long codigoPerito;
    private Long codigoCFC;
    private Long codigoConcessionaria;
    private String nomeVendedor;
    private LocalDate dataAbertura;
    private LocalDate dataConclusao;
    private Boolean papelTimbrado;
    private String historico;
    private LocalDate dataSolicitacao;
    private Long numeroSolicitacao;
    private Integer tipoSolicitacao;
    private Integer motivoSolicitacao;
    private StatusProcesso status;
    private LocalDateTime dataCriacaoRegistro;
    private LocalDateTime dataAtualizacaoRegistro;
}
