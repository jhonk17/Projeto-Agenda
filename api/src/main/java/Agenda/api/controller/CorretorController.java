package Agenda.api.controller;

import Agenda.api.corretor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("corretores")
public class CorretorController {

    @Autowired
    private CorretorRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCorretor dados) {
        repository.save(new Corretor(dados));

    }
    @GetMapping
    public Page<DadosListagemCorretor> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCorretor::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCorretor dados) {
        var corretor = repository.getReferenceById(dados.id());
        corretor.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public  void excluir(@PathVariable Long id) {
        var corretor = repository.getReferenceById(id);
        corretor.excluir();
    }



}
