package com.example.pedido_api.controller;

import com.example.pedido_api.dto.PedidoDTO;
import com.example.pedido_api.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criar(@Valid @RequestBody PedidoDTO dto) {
        PedidoDTO criado = service.criar(dto);
        return ResponseEntity.created(URI.create("api/pedidos" + criado.getId())).body(criado);
    }

    @GetMapping("/faturados")
    public ResponseEntity<List<PedidoDTO>> findPedidosFaturados() {
        return ResponseEntity.ok(service.findPedidosFaturados());
    }
}
