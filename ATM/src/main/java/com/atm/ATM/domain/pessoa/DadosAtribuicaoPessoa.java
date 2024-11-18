package com.atm.ATM.domain.pessoa;

public record DadosAtribuicaoPessoa(Long id, String nome) {
    public DadosAtribuicaoPessoa(Pessoa dados){
        this(
                dados.getId(),
                dados.getNome()
        );
    }
}
