package com.atm.ATM.controller;

import com.atm.ATM.domain.categoria.Categoria;
import com.atm.ATM.domain.categoria.CategoriaRepository;
import com.atm.ATM.domain.categoria.DadosCadastroCategoria;
import com.atm.ATM.domain.categoria.DadosDetalhamentoCategoria;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder uriBuilder) {
        var categoria = new Categoria(dados);
        repository.save(categoria);
        var uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(repository.findByAtivoTrue(Sort.by("nome")));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroCategoria dados, @PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        categoria.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        categoria.excluir();
        return ResponseEntity.noContent().build();
    }

}
