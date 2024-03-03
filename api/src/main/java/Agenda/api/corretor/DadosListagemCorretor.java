package Agenda.api.corretor;

import Agenda.api.endereco.Endereco;

public record DadosListagemCorretor(Long id, String nome, String email, String mediador, Especialidade especialidade, Endereco endereco) {

    public DadosListagemCorretor(Corretor corretor){
        this(corretor.getId(), corretor.getNome(), corretor.getEmail(), corretor.getMediador(), corretor.getEspecialidade(), corretor.getEndereco());

    }

}
