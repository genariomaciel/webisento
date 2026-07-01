package br.com.isento.webisento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {
    private Long id;
    private Long numeroProcesso;
    private Integer sequencia;
    private Integer codigo;
    private String nome;
    private String observacao;
    private LocalDateTime dataCriacaoRegistro;
    private LocalDateTime dataAtualizacaoRegistro;
}
