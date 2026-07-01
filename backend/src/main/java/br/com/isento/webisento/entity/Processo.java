package br.com.isento.webisento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "processos")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long numeroProcesso;

    @Column(nullable = false)
    private Long codigoRequerente;

    @Column(nullable = false)
    private Integer codigoTipoRequerente;

    @Column
    private Long codigoPerito;

    @Column
    private Long codigoCFC;

    @Column
    private Long codigoConcessionaria;

    @Column(length = 255)
    private String nomeVendedor;

    @Column(nullable = false)
    private LocalDate dataAbertura;

    @Column
    private LocalDate dataConclusao;

    @Column
    private Boolean papelTimbrado = false;

    @Column(columnDefinition = "TEXT")
    private String historico;

    @Column(nullable = false)
    private LocalDate dataSolicitacao;

    @Column(nullable = false)
    private Long numeroSolicitacao;

    @Column(nullable = false)
    private Integer tipoSolicitacao;

    @Column(nullable = false)
    private Integer motivoSolicitacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProcesso status = StatusProcesso.PENDENTE;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacaoRegistro = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacaoRegistro = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacaoRegistro = LocalDateTime.now();
    }
}
