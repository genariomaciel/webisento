package br.com.isento.webisento.dto;

import br.com.isento.webisento.entity.StatusCondutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondutorDTO {
    private Long id;
    private Long numeroProcesso;
    private String cpf;
    private String nome;
    private String numeroRG;
    private String codigoOrgaoExpedidor;
    private LocalDate dataExpedicao;
    private String numeroCNH;
    private LocalDate dataEmissaoCNH;
    private LocalDate dataValidadeCNH;
    private LocalDate dataCadastro;
    private String cep;
    private String ddd;
    private String telefone;
    private String celular;
    private String email;
    private StatusCondutor status;
    private LocalDateTime dataCriacaoRegistro;
    private LocalDateTime dataAtualizacaoRegistro;
}
