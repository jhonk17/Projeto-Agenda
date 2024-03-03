package Agenda.api.Clientes;

import Agenda.api.endereco.DadosEndereco;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank(message = "O telefone é obrigatório")
        @Pattern(regexp = "\\d{10,11}", message = "O Telefone precisa conter 11 dígitos")
        @Column(unique = true)
        String telefone,
        @NotBlank(message = "O CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "O CPF precisa conter 11 dígitos")
        @Column(unique=true)
        String cpf,

        DadosEndereco Endereco
) {
}
