package com.atm.ATM.domain.pessoa;

import com.atm.ATM.domain.endereco.Endereco;

public record DadosListagemPessoa(Long id, String nome, boolean ativo) {
    public DadosListagemPessoa(Pessoa dados){
        this(
                dados.getId(),
                dados.getNome(),
                dados.getAtivo()
        );
    }
}
