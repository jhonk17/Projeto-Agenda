package Agenda.api.Clientes;

import Agenda.api.endereco.Endereco;

public record DadosListagemCliente(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {
    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(),cliente.getEndereco());
    }
}
