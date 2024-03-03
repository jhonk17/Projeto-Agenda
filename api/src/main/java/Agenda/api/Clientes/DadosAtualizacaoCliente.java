package Agenda.api.Clientes;

import Agenda.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        DadosEndereco endereco) {

}
