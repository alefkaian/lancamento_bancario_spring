package com.atm.ATM.domain.pessoa;

import com.atm.ATM.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPessoa(
        String nome,
        DadosEndereco endereco,
        Boolean ativo) {
}
