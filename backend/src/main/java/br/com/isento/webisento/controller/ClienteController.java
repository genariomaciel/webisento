package br.com.isento.webisento.controller;

import br.com.isento.webisento.dto.ClienteDTO;
import br.com.isento.webisento.entity.StatusCliente;
import br.com.isento.webisento.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "Gerenciamento de clientes/requerentes")
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    @Operation(summary = "Criar novo cliente")
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO dto) {
        ClienteDTO criado = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter cliente por ID")
    public ResponseEntity<ClienteDTO> obterPorId(@PathVariable Long id) {
        ClienteDTO dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todos os clientes")
    public ResponseEntity<List<ClienteDTO>> listar() {
        List<ClienteDTO> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Listar clientes por status")
    public ResponseEntity<List<ClienteDTO>> listarPorStatus(@PathVariable StatusCliente status) {
        List<ClienteDTO> lista = service.listarPorStatus(status);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/nome")
    @Operation(summary = "Buscar clientes por nome")
    public ResponseEntity<List<ClienteDTO>> buscarPorNome(@RequestParam String nome) {
        List<ClienteDTO> lista = service.buscarPorNome(nome);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/cidade")
    @Operation(summary = "Buscar clientes por cidade")
    public ResponseEntity<List<ClienteDTO>> buscarPorCidade(@RequestParam String cidade) {
        List<ClienteDTO> lista = service.buscarPorCidade(cidade);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        ClienteDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cliente")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
