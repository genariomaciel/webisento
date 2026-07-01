package br.com.isento.webisento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitacoes")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeRequerente;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String placaVeiculo;

    @Column(nullable = false)
    private String marcaVeiculo;

    @Column(nullable = false)
    private String modeloVeiculo;

    @Column(nullable = false)
    private Integer anoVeiculo;

    @Column(nullable = false)
    private String tipoVeiculo;

    @Column(precision = 19, scale = 2)
    private Double valorVeiculo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusSolicitacao status = StatusSolicitacao.PENDENTE;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }
}
