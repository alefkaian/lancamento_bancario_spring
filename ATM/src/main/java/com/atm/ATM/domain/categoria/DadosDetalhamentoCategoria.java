package com.atm.ATM.domain.categoria;

public record DadosDetalhamentoCategoria(Long id, String nome, boolean ativo) {
    public DadosDetalhamentoCategoria(Categoria dados){
        this(
                dados.getId(),
                dados.getNome(),
                dados.getAtivo()
        );
    }
}
