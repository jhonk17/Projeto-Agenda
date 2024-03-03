package Agenda.api.controller;

import Agenda.api.Clientes.*;
import Agenda.api.Clientes.DadosAtualizacaoCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados ) {
        repository.save(new Cliente(dados));
    }
    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"})Pageable paginacao) {
        return  repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados ) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.inativar();
    }
}
