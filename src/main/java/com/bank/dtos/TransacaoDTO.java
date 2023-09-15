package com.bank.dtos;

import java.math.BigDecimal;

/**
 * DTO de Transação, ou seja, uma versão simplificada de transação que recebe o valor, o id do pagador e o id do recebedor.
 *
 * @param valor Valor da transação.
 * @param pagadorId ID do pagador.
 * @param recebedorId ID do recebedor.
 */
public record TransacaoDTO(BigDecimal valor, Long pagadorId, Long recebedorId) {
}
