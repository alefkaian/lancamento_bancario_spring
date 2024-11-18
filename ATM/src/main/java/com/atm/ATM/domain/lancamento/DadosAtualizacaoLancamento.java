package com.atm.ATM.domain.lancamento;

import java.math.BigDecimal;

public record DadosAtualizacaoLancamento(
        String descricao,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo,
        Long idCategoria,
        Boolean ativo
) {
}
