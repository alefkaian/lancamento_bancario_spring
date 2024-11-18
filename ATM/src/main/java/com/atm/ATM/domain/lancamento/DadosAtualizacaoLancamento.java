package com.atm.ATM.domain.lancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLancamento(
        String descricao,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo,
        Long idCategoria,
        Boolean ativo
) {
}
