package com.bank.dtos;

import java.math.BigDecimal;

/**
 * DTO de Depósito, ou seja, uma versão simplificada de deposito que recebe o valor e o id do usuário.
 *
 * @param valor Valor que deseja depositar.
 * @param usuarioId Usuário que está recebendo o deposito.
 */
public record DepositoDTO(BigDecimal valor, Long usuarioId) {
}
