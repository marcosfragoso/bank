package com.bank.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

/**
 * Representação de um usuário de um banco contendo as seguintes informações: id, nome, sobrenome, cpf, email, senha, saldo e tipo do usuário.
 * A anotation @Entity é utilizada para marcar a classe Usuário como uma entidade JPA representando uma tabela no banco de dados.
 * A anotation @Table é utilizada para especificar o nome da tabela no banco de dados que está associada à entidade JPA.
 * As anotations @Getter, @Setter, @AllArgsConstructor e @EqualsAndHashCode(of = "id") se refere a criação dos getters, setters, contrutores, equals e hashCode automaticamente pela ferramente Lombok.
 */
@Entity(name = "usuarios")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    /**
     * Chave primária da tabela. É um identificador único que é autoincrementado exclusivamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do usuário.
     */
    private String nome;

    /**
     * Sobrenome do usuário.
     */
    private String sobrenome;

    /**
     * CPF do usuário. É do tipo único, pois a modelagem não permite CPFs repetidos.
     */
    @Column(unique = true)
    private String cpf;

    /**
     * Email do usuário. É do tipo único, pois a modelagem não permite emails repetidos.
     */
    @Column(unique = true)
    private String email;

    /**
     * Senha do usuário.
     */
    private String senha;

    /**
     * Saldo da conta do usuário.
     */
    private BigDecimal saldo;

    /**
     * Tipo do usuário. É uma enumeração em String (comum ou comerciante)
     */
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

}
