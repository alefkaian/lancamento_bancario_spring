package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.categoria.Categoria;
import com.atm.ATM.domain.pessoa.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoLancamento(Long id, String descricao, BigDecimal Valor, LocalDate dataPagamento,
                                          LocalDate dataVencimento, String categoria, String pessoa) {
    public DadosDetalhamentoLancamento(Lancamento dados) {
        this(
                dados.getId(),
                dados.getDescricao(),
                dados.getValor(),
                dados.getDataPagamento(),
                dados.getDataVencimento(),
                dados.getCategoria().getNome(),
                dados.getPessoa().getNome()
        );
    }
}