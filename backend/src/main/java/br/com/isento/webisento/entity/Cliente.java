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
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dados Pessoais
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

    @Column(length = 20)
    private String numeroCNH;

    @Column
    private LocalDate dataEmissaoCNH;

    @Column
    private LocalDate dataValidadeCNH;

    @Column(length = 20)
    private String numeroINSS;

    @Column
    private Integer codigoRegimeContribuicao;

    @Column
    private Integer codigoTipoSegurado;

    @Column(length = 255)
    private String nomeRepresentante;

    @Column(length = 11)
    private String cpfRepresentante;

    @Column(length = 20)
    private String numeroRGRepresentante;

    @Column(length = 255)
    private String nomeCondominio;

    // Endereço
    @Column
    private Integer codigoTipoLogradouro;

    @Column(length = 255)
    private String nomeLogradouro;

    @Column
    private Integer numeroLogradouro;

    @Column(length = 255)
    private String complemento;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String cidade;

    @Column
    private Integer codigoEstado;

    @Column(length = 10)
    private String cep;

    // Contato
    @Column(length = 5)
    private String ddd;

    @Column(length = 15)
    private String telefone;

    @Column(length = 15)
    private String celular;

    @Column(length = 100)
    private String email;

    // Status e Auditoria
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCliente status = StatusCliente.ATIVO;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacaoRegistro = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacaoRegistro = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacaoRegistro = LocalDateTime.now();
    }
}
