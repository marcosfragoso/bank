package com.bank.dtos;

/**
 * DTO de uma Exceção, ou seja, uma versão simplificada de Exception que recebe uma mensagem e o statusCode.
 *
 * @param mensagem A mensagem a ser passada.
 * @param statusCode O statusCode.
 */
public record ExceptionDTO(String mensagem, String statusCode) {
}
