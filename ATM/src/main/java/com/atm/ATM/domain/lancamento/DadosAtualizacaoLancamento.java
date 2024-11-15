package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.categoria.Categoria;
import com.atm.ATM.domain.categoria.DadosAtribuicaoCategoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLancamento(
        String descricao,
        @NotNull
        @Pattern(regexp = "/^\\d*\\.?\\d*$/")
        BigDecimal valor,
        String observacao,
        @Valid
        TipoLancamento tipo,
        @NotNull
        Long idCategoria
) {
}
