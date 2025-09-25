package com.example.pedido_api.dto;

import com.example.pedido_api.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PedidoDTO {

    private Long id;

    @NotNull(message = "Cliente é obrigatório!")
    private Cliente cliente;

    @NotBlank(message = "Descrição é obrigatório!")
    @Size(max = 100)
    private String descricao;

    private Boolean faturado;

    private LocalDate dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Cliente é obrigatório!") Cliente getCliente() {
        return cliente;
    }

    public void setCliente(@NotNull(message = "Cliente é obrigatório!") Cliente cliente) {
        this.cliente = cliente;
    }

    public @NotBlank(message = "Descrição é obrigatório!") @Size(max = 100) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "Descrição é obrigatório!") @Size(max = 100) String descricao) {
        this.descricao = descricao;
    }

    public Boolean getFaturado() {
        return faturado;
    }

    public void setFaturado(Boolean faturado) {
        this.faturado = faturado;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
