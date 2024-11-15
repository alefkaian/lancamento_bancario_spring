package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.categoria.Categoria;
import com.atm.ATM.domain.categoria.DadosAtribuicaoCategoria;
import com.atm.ATM.domain.pessoa.DadosAtribuicaoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroLancamento(
        String descricao,
        @NotNull
        LocalDate dataVencimento,
        @NotNull
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
