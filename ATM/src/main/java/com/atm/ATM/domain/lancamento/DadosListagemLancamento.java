package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.pessoa.DadosAtribuicaoPessoa;
import com.atm.ATM.domain.pessoa.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemLancamento(Long id, BigDecimal valor, LocalDate dataPagamento,
                                      LocalDate dataVencimento, Pessoa pessoa) {
    public DadosListagemLancamento(Lancamento dados) {
        this(
                dados.getId(),
                dados.getValor(),
                dados.getDataPagamento(),
                dados.getDataVencimento(),
                dados.getPessoa()
        );
    }
}
