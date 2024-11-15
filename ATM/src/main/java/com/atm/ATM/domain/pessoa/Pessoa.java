package com.atm.ATM.domain.pessoa;

import com.atm.ATM.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity(name = "Pessoa")
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.endereco() != null) this.endereco.atualizarInformacoes(dados.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }
}

