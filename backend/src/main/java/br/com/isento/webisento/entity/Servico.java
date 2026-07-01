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
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long numeroProcesso;

    @Column(nullable = false)
    private Integer sequencia;

    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacaoRegistro = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacaoRegistro = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacaoRegistro = LocalDateTime.now();
    }
}
