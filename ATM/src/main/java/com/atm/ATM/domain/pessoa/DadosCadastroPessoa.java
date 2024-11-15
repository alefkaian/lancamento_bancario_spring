package com.atm.ATM.domain.pessoa;

import com.atm.ATM.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @Valid
        DadosEndereco endereco
) {
}
