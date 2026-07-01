package br.com.isento.webisento.dto;

import br.com.isento.webisento.entity.StatusProcurador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcuradorDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String numeroRG;
    private String codigoOrgaoExpedidor;
    private LocalDate dataExpedicao;
    private LocalDate dataCadastro;
    private String nacionalidade;
    private Integer codigoEstadoCivil;
    private String nomeEstadoCivil;
    private String email;
    private String telefone;
    private String celular;
    private StatusProcurador status;
    private LocalDateTime dataCriacaoRegistro;
    private LocalDateTime dataAtualizacaoRegistro;
}
