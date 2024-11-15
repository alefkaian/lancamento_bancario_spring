package com.atm.ATM.controller;
import com.atm.ATM.domain.categoria.Categoria;
import com.atm.ATM.domain.categoria.CategoriaRepository;
import com.atm.ATM.domain.lancamento.*;
import com.atm.ATM.domain.pessoa.Pessoa;
import com.atm.ATM.domain.pessoa.PessoaRepository;
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
@RequestMapping("/lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoRepository repository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLancamento dados, UriComponentsBuilder uriBuilder) {
        Categoria categoria = categoriaRepository.getReferenceById(dados.idCategoria());
        Pessoa pessoa = pessoaRepository.getReferenceById(dados.idPessoa());
        var lancamento = new Lancamento(dados, categoria, pessoa);
        repository.save(lancamento);
        var uri = uriBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemLancamento>> listar(@RequestParam(defaultValue =  "0") int page){
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").ascending());
        return ResponseEntity.ok().body(repository.findByAtivoTrue(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var lancamento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados, @PathVariable Long id){
        Categoria categoria = categoriaRepository.getReferenceById(dados.idCategoria());
        var lancamento = repository.getReferenceById(id);
        lancamento.atualizarInformacoes(dados, categoria);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var lancamento = repository.getReferenceById(id);
        lancamento.excluir();
        return ResponseEntity.noContent().build();
    }
}
