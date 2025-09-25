package com.example.pedido_api.services;

import com.example.pedido_api.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO criar(ClienteDTO dto);

    List<ClienteDTO> listarTodos();

    void deletar(Long id);
}
