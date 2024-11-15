package com.atm.ATM.controller;

import com.atm.ATM.domain.pessoa.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPessoa>> listar(@RequestParam(defaultValue =  "0") int page){
        Pageable pageable = PageRequest.of(page, 10, Sort.by("nome").ascending());
        return ResponseEntity.ok().body(repository.findByAtivoTrue(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados, @PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        pessoa.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        pessoa.excluir();
        return ResponseEntity.noContent().build();
    }
}
