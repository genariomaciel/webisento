package br.com.isento.webisento.dto;

import br.com.isento.webisento.entity.StatusCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String numeroRG;
    private String codigoOrgaoExpedidor;
    private LocalDate dataExpedicao;
    private LocalDate dataCadastro;
    private String numeroCNH;
    private LocalDate dataEmissaoCNH;
    private LocalDate dataValidadeCNH;
    private String numeroINSS;
    private Integer codigoRegimeContribuicao;
    private Integer codigoTipoSegurado;
    private String nomeRepresentante;
    private String cpfRepresentante;
    private String numeroRGRepresentante;
    private String nomeCondominio;
    private Integer codigoTipoLogradouro;
    private String nomeLogradouro;
    private Integer numeroLogradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private Integer codigoEstado;
    private String cep;
    private String ddd;
    private String telefone;
    private String celular;
    private String email;
    private StatusCliente status;
    private LocalDateTime dataCriacaoRegistro;
    private LocalDateTime dataAtualizacaoRegistro;
}
