package Agenda.api.corretor;

import Agenda.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCorretor(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
