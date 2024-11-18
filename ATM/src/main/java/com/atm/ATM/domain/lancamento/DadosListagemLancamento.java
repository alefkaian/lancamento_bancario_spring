package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.pessoa.DadosAtribuicaoPessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemLancamento(Long id, String descricao, BigDecimal valor, LocalDate dataPagamento,
                                      LocalDate dataVencimento, DadosAtribuicaoPessoa pessoa) {
    public DadosListagemLancamento(Lancamento dados) {
        this(
                dados.getId(),
                dados.getDescricao(),
                dados.getValor(),
                dados.getDataPagamento(),
                dados.getDataVencimento(),
                new DadosAtribuicaoPessoa(dados.getPessoa())
        );
    }
}
