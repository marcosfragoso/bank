package com.bank.dtos;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal valor, Long pagadorId, Long recebedorId) {
}
