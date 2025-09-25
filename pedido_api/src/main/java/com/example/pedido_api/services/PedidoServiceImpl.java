package com.example.pedido_api.services;

import com.example.pedido_api.dto.PedidoDTO;
import com.example.pedido_api.model.Pedido;
import com.example.pedido_api.repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    private PedidoDTO toDto(Pedido p) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(p.getId());
        dto.setDescricao(p.getDescricao());
        dto.setCliente(p.getCliente());
        dto.setFaturado(p.getFaturado());
        dto.setDataCadastro(p.getDataCadastro());
        return dto;
    }

    private Pedido toEntity(PedidoDTO dto) {
        Pedido p = new Pedido();
        p.setDescricao(dto.getDescricao());
        p.setCliente(dto.getCliente());
        return p;
    }

    @Override
    public PedidoDTO criar(PedidoDTO dto) {
        Pedido p = toEntity(dto);
        p = repository.save(p);
        return toDto(p);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PedidoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<PedidoDTO> findPedidosFaturados() {
        return repository.findByFaturado(Boolean.TRUE).stream().map(this::toDto).collect(Collectors.toList());
    }
}
