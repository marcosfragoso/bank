package com.bank.dtos;

import java.math.BigDecimal;

/**
 * DTO de Saque, ou seja, uma versão simplificada de saque que recebe o valor e o id do usuário.
 *
 * @param valor Valor que deseja sacar.
 * @param usuarioId Usuário que está realizando o saque.
 */
public record SaqueDTO(BigDecimal valor, Long usuarioId) {
}
