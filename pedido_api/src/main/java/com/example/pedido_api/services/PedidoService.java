package com.example.pedido_api.services;

import com.example.pedido_api.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {
    PedidoDTO criar(PedidoDTO dto);

    List<PedidoDTO> listarTodos();

    void deletar(Long id);

    List<PedidoDTO> findPedidosFaturados();
}
