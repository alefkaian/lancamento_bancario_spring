package com.atm.ATM.domain.categoria;

public record DadosDetalhamentoCategoria(Long id, String nome) {
    public DadosDetalhamentoCategoria(Categoria dados){
        this(
                dados.getId(),
                dados.getNome()
        );
    }
}
