package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.pessoa.DadosAtribuicaoPessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemLancamento(Long id, String descricao, LocalDate dataVencimento,
                                      LocalDate dataPagamento, BigDecimal valor, DadosAtribuicaoPessoa pessoa) {
    public DadosListagemLancamento(Lancamento dados) {
        this(
                dados.getId(),
                dados.getDescricao(),
                dados.getDataVencimento(),
                dados.getDataPagamento(),
                dados.getValor(),
                new DadosAtribuicaoPessoa(dados.getPessoa())
        );
    }
}
