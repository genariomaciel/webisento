package br.com.isento.webisento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peritos")
public class Perito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpfCnpj;

    @Column(length = 1)
    private Integer tipoPessoa; // 1: Física, 2: Jurídica

    @Column(length = 20)
    private String numeroRG;

    @Column(length = 10)
    private String codigoOrgaoExpedidor;

    @Column
    private LocalDate dataExpedicao;

    @Column
    private LocalDate dataCadastro;

    @Column(length = 20)
    private String inscricaoEstadual;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Column(length = 15)
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPerito status = StatusPerito.ATIVO;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacaoRegistro = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacaoRegistro = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacaoRegistro = LocalDateTime.now();
    }
}
