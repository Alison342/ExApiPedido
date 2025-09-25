package com.example.pedido_api.services;

import com.example.pedido_api.dto.ClienteDTO;
import com.example.pedido_api.model.Cliente;
import com.example.pedido_api.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    private ClienteDTO toDto(Cliente c) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(c.getId());
        dto.setNome(c.getNome());
        dto.setEmail(c.getEmail());
        dto.setTelefone(c.getTelefone());
        dto.setCpf(c.getCpf());
        dto.setPedidos(c.getPedidos());
        return dto;
    }

    private Cliente toEntity(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setId(dto.getId());
        c.setNome(dto.getNome());
        c.setEmail(dto.getEmail());
        c.setTelefone(dto.getTelefone());
        c.setCpf(dto.getCpf());
        c.setPedidos(dto.getPedidos());
        return c;
    }

    @Override
    public ClienteDTO criar(ClienteDTO dto) {
        Cliente c = toEntity(dto);
        c = repository.save(c);
        return toDto(c);
    }

    @Override
    public List<ClienteDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
