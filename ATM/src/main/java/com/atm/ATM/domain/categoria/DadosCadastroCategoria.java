package com.atm.ATM.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCategoria(
        @NotBlank
        @NotNull
        String nome
) {
}
