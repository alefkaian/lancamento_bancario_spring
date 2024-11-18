package com.atm.ATM.domain.lancamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroLancamento(
        String descricao,
        @NotNull
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        @NotNull
        BigDecimal valor,
        String observacao,
        @Valid
        TipoLancamento tipo,
        @NotNull
        Long idCategoria,
        @NotNull
        Long idPessoa
) {
}
