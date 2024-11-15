package com.atm.ATM.domain.pessoa;

import com.atm.ATM.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(String nome, DadosEndereco endereco) {
}
