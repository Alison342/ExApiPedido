package com.example.pedido_api.dto;

import com.example.pedido_api.model.Pedido;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public class ClienteDTO {

    private Long id;

    @NotNull(message = "Nome é obrigatório!")
    @Size(max = 120)
    private String nome;

    @NotNull(message = "Email é obrigatório!")
    @Size(max = 60)
    private String email;

    @Size(max = 20)
    private String telefone;

    @CPF
    @Size(max = 12)
    private String cpf;

    private List<Pedido> pedidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Nome é obrigatório!") @Size(max = 120) String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "Nome é obrigatório!") @Size(max = 120) String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "Email é obrigatório!") @Size(max = 60) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "Email é obrigatório!") @Size(max = 60) String email) {
        this.email = email;
    }

    public @Size(max = 20) String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Size(max = 20) String telefone) {
        this.telefone = telefone;
    }

    public @CPF @Size(max = 12) String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF @Size(max = 12) String cpf) {
        this.cpf = cpf;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
