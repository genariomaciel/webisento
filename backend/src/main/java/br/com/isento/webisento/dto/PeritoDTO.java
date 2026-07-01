package br.com.isento.webisento.dto;

import br.com.isento.webisento.entity.StatusPerito;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeritoDTO {
    private Long id;
    private String nome;
    private String cpfCnpj;
    private Integer tipoPessoa;
    private String numeroRG;
    private String codigoOrgaoExpedidor;
    private LocalDate dataExpedicao;
    private LocalDate dataCadastro;
    private String inscricaoEstadual;
    private String email;
    private String telefone;
    private String celular;
    private StatusPerito status;
    private LocalDateTime dataCriacaoRegistro;
    private LocalDateTime dataAtualizacaoRegistro;
}
