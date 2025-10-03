package com.atm.ATM.controller;

import com.atm.ATM.domain.usuario.DadosCadastroUsuario;
import com.atm.ATM.domain.usuario.DadosDetalhamentoUsuario;
import com.atm.ATM.domain.usuario.Usuario;
import com.atm.ATM.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){
        if (repository.findByLogin(dados.login()) != null){
            return ResponseEntity.badRequest().body("Login em uso!!!");
        }

        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(dados.login(), senhaCriptografada);
        repository.save(usuario);
        var uri = uriBuilder.path("/cadastros/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }
}
