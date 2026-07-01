package br.com.isento.webisento.controller;

import br.com.isento.webisento.dto.SolicitacaoDTO;
import br.com.isento.webisento.entity.StatusSolicitacao;
import br.com.isento.webisento.service.SolicitacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitacoes")
@RequiredArgsConstructor
@Tag(name = "Solicitações", description = "Gerenciamento de solicitações de isenção")
public class SolicitacaoController {

    private final SolicitacaoService service;

    @PostMapping
    @Operation(summary = "Criar nova solicitação")
    public ResponseEntity<SolicitacaoDTO> criar(@RequestBody SolicitacaoDTO dto) {
        SolicitacaoDTO criada = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter solicitação por ID")
    public ResponseEntity<SolicitacaoDTO> obterPorId(@PathVariable Long id) {
        SolicitacaoDTO dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todas as solicitações")
    public ResponseEntity<List<SolicitacaoDTO>> listar() {
        List<SolicitacaoDTO> lista = service.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Listar solicitações por status")
    public ResponseEntity<List<SolicitacaoDTO>> listarPorStatus(@PathVariable StatusSolicitacao status) {
        List<SolicitacaoDTO> lista = service.listarPorStatus(status);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar solicitação")
    public ResponseEntity<SolicitacaoDTO> atualizar(@PathVariable Long id, @RequestBody SolicitacaoDTO dto) {
        SolicitacaoDTO atualizada = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar solicitação")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
