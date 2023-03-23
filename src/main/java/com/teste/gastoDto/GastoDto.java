package com.teste.gastoDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public record GastoDto(
        @NotBlank
        @Size(max = 30)
        String nome,
        @NotBlank
        @Size(max = 45)
        String descricao,
        @NotNull
        BigDecimal valor,
        @NotBlank
        @Size(max = 45)
        String tags
                       ) {
}
