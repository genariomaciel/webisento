package br.com.isento.webisento.service;

import br.com.isento.webisento.dto.ClienteDTO;
import br.com.isento.webisento.entity.Cliente;
import br.com.isento.webisento.entity.StatusCliente;
import br.com.isento.webisento.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public ClienteDTO criar(ClienteDTO dto) {
        // Verificar se CPF já existe
        if (repository.findByCpf(dto.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado no sistema");
        }

        Cliente cliente = mapToEntity(dto);
        Cliente salvo = repository.save(cliente);
        return mapToDTO(salvo);
    }

    @Transactional(readOnly = true)
    public ClienteDTO obterPorId(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> listarPorStatus(StatusCliente status) {
        return repository.findByStatus(status).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> buscarPorCidade(String cidade) {
        return repository.findByCidadeContainingIgnoreCase(cidade).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(dto.getNome());
        cliente.setNumeroRG(dto.getNumeroRG());
        cliente.setCodigoOrgaoExpedidor(dto.getCodigoOrgaoExpedidor());
        cliente.setDataExpedicao(dto.getDataExpedicao());
        cliente.setDataCadastro(dto.getDataCadastro());
        cliente.setNumeroCNH(dto.getNumeroCNH());
        cliente.setDataEmissaoCNH(dto.getDataEmissaoCNH());
        cliente.setDataValidadeCNH(dto.getDataValidadeCNH());
        cliente.setNumeroINSS(dto.getNumeroINSS());
        cliente.setCodigoRegimeContribuicao(dto.getCodigoRegimeContribuicao());
        cliente.setCodigoTipoSegurado(dto.getCodigoTipoSegurado());
        cliente.setNomeRepresentante(dto.getNomeRepresentante());
        cliente.setCpfRepresentante(dto.getCpfRepresentante());
        cliente.setNumeroRGRepresentante(dto.getNumeroRGRepresentante());
        cliente.setNomeCondominio(dto.getNomeCondominio());
        cliente.setCodigoTipoLogradouro(dto.getCodigoTipoLogradouro());
        cliente.setNomeLogradouro(dto.getNomeLogradouro());
        cliente.setNumeroLogradouro(dto.getNumeroLogradouro());
        cliente.setComplemento(dto.getComplemento());
        cliente.setBairro(dto.getBairro());
        cliente.setCidade(dto.getCidade());
        cliente.setCodigoEstado(dto.getCodigoEstado());
        cliente.setCep(dto.getCep());
        cliente.setDdd(dto.getDdd());
        cliente.setTelefone(dto.getTelefone());
        cliente.setCelular(dto.getCelular());
        cliente.setEmail(dto.getEmail());
        cliente.setStatus(dto.getStatus());

        Cliente atualizado = repository.save(cliente);
        return mapToDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private Cliente mapToEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setNumeroRG(dto.getNumeroRG());
        cliente.setCodigoOrgaoExpedidor(dto.getCodigoOrgaoExpedidor());
        cliente.setDataExpedicao(dto.getDataExpedicao());
        cliente.setDataCadastro(dto.getDataCadastro());
        cliente.setNumeroCNH(dto.getNumeroCNH());
        cliente.setDataEmissaoCNH(dto.getDataEmissaoCNH());
        cliente.setDataValidadeCNH(dto.getDataValidadeCNH());
        cliente.setNumeroINSS(dto.getNumeroINSS());
        cliente.setCodigoRegimeContribuicao(dto.getCodigoRegimeContribuicao());
        cliente.setCodigoTipoSegurado(dto.getCodigoTipoSegurado());
        cliente.setNomeRepresentante(dto.getNomeRepresentante());
        cliente.setCpfRepresentante(dto.getCpfRepresentante());
        cliente.setNumeroRGRepresentante(dto.getNumeroRGRepresentante());
        cliente.setNomeCondominio(dto.getNomeCondominio());
        cliente.setCodigoTipoLogradouro(dto.getCodigoTipoLogradouro());
        cliente.setNomeLogradouro(dto.getNomeLogradouro());
        cliente.setNumeroLogradouro(dto.getNumeroLogradouro());
        cliente.setComplemento(dto.getComplemento());
        cliente.setBairro(dto.getBairro());
        cliente.setCidade(dto.getCidade());
        cliente.setCodigoEstado(dto.getCodigoEstado());
        cliente.setCep(dto.getCep());
        cliente.setDdd(dto.getDdd());
        cliente.setTelefone(dto.getTelefone());
        cliente.setCelular(dto.getCelular());
        cliente.setEmail(dto.getEmail());
        cliente.setStatus(dto.getStatus() != null ? dto.getStatus() : StatusCliente.ATIVO);
        return cliente;
    }

    private ClienteDTO mapToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setNumeroRG(cliente.getNumeroRG());
        dto.setCodigoOrgaoExpedidor(cliente.getCodigoOrgaoExpedidor());
        dto.setDataExpedicao(cliente.getDataExpedicao());
        dto.setDataCadastro(cliente.getDataCadastro());
        dto.setNumeroCNH(cliente.getNumeroCNH());
        dto.setDataEmissaoCNH(cliente.getDataEmissaoCNH());
        dto.setDataValidadeCNH(cliente.getDataValidadeCNH());
        dto.setNumeroINSS(cliente.getNumeroINSS());
        dto.setCodigoRegimeContribuicao(cliente.getCodigoRegimeContribuicao());
        dto.setCodigoTipoSegurado(cliente.getCodigoTipoSegurado());
        dto.setNomeRepresentante(cliente.getNomeRepresentante());
        dto.setCpfRepresentante(cliente.getCpfRepresentante());
        dto.setNumeroRGRepresentante(cliente.getNumeroRGRepresentante());
        dto.setNomeCondominio(cliente.getNomeCondominio());
        dto.setCodigoTipoLogradouro(cliente.getCodigoTipoLogradouro());
        dto.setNomeLogradouro(cliente.getNomeLogradouro());
        dto.setNumeroLogradouro(cliente.getNumeroLogradouro());
        dto.setComplemento(cliente.getComplemento());
        dto.setBairro(cliente.getBairro());
        dto.setCidade(cliente.getCidade());
        dto.setCodigoEstado(cliente.getCodigoEstado());
        dto.setCep(cliente.getCep());
        dto.setDdd(cliente.getDdd());
        dto.setTelefone(cliente.getTelefone());
        dto.setCelular(cliente.getCelular());
        dto.setEmail(cliente.getEmail());
        dto.setStatus(cliente.getStatus());
        dto.setDataCriacaoRegistro(cliente.getDataCriacaoRegistro());
        dto.setDataAtualizacaoRegistro(cliente.getDataAtualizacaoRegistro());
        return dto;
    }
}
