package com.bank.dtos;

import com.bank.domain.usuario.TipoUsuario;

import java.math.BigDecimal;


/**
 * DTO de um Usuario, ou seja, uma versão simplificada de Usuário, onde recebe nome, sobrenome, cpf, saldo, email, senha e tipo de usuário.
 * @param nome Nome do usuário.
 * @param sobrenome Sobrenome do usuário.
 * @param cpf CPF do usuário.
 * @param saldo Saldo do usuário.
 * @param email Email do usuário.
 * @param senha Senha do usuário.
 * @param tipoUsuario Tipo do usuário.
 */
public record UsuarioDTO(String nome, String sobrenome, String cpf, BigDecimal saldo, String email, String senha, TipoUsuario tipoUsuario) {
}
