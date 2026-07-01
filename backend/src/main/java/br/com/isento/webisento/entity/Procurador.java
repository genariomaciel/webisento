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
@Table(name = "procuradores")
public class Procurador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(length = 20)
    private String numeroRG;

    @Column(length = 10)
    private String codigoOrgaoExpedidor;

    @Column
    private LocalDate dataExpedicao;

    @Column
    private LocalDate dataCadastro;

    @Column(length = 50)
    private String nacionalidade;

    @Column
    private Integer codigoEstadoCivil;

    @Column(length = 50)
    private String nomeEstadoCivil;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Column(length = 15)
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusProcurador status = StatusProcurador.ATIVO;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacaoRegistro = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacaoRegistro = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacaoRegistro = LocalDateTime.now();
    }
}
