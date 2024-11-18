package com.atm.ATM.domain.pessoa;

import com.atm.ATM.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(Long id, String nome, Endereco endereco, boolean ativo) {
    public DadosDetalhamentoPessoa(Pessoa dados) {
        this(
                dados.getId(),
                dados.getNome(),
                dados.getEndereco(),
                dados.getAtivo()
        );
    }
}
