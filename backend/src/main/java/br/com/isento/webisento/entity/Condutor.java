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
@Table(name = "condutores")
public class Condutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long numeroProcesso;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 20)
    private String numeroRG;

    @Column(length = 10)
    private String codigoOrgaoExpedidor;

    @Column
    private LocalDate dataExpedicao;

    @Column(length = 20)
    private String numeroCNH;

    @Column
    private LocalDate dataEmissaoCNH;

    @Column
    private LocalDate dataValidadeCNH;

    @Column
    private LocalDate dataCadastro;

    @Column(length = 10)
    private String cep;

    @Column(length = 5)
    private String ddd;

    @Column(length = 15)
    private String telefone;

    @Column(length = 15)
    private String celular;

    @Column(length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCondutor status = StatusCondutor.ATIVO;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacaoRegistro = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacaoRegistro = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacaoRegistro = LocalDateTime.now();
    }
}
