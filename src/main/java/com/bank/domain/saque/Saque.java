package com.bank.domain.saque;

import com.bank.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representação de um saque de um banco contendo as seguintes informações: id, usuário que vai sacar, valor do saque e a data.
 * A anotation @Entity é utilizada para marcar a classe Saque como uma entidade JPA representando uma tabela no banco de dados.
 * A anotation @Table é utilizada para especificar o nome da tabela no banco de dados que está associada à entidade JPA.
 * As anotations @Getter, @Setter, @AllArgsConstructor e @EqualsAndHashCode(of = "id") se refere a criação dos getters, setters, contrutores, equals e hashCode automaticamente pela ferramente Lombok.
 */
@Entity(name = "saques")
@Table(name = "saques")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Saque {
    /**
     * Chave primária da tabela. É um identificador único que é autoincrementado exclusivamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * O usuário que está efetuando o saque.
     * Anotation @ManyToOne referente ao relacionamento de Saque com Usuario. Relacionamento muitos para um, ou seja, um usuário pode ter vários saques e um saque apenas um usuário.
     * Anotation @JoinColumn usada em conjunto com o ManyToOne que tá usando o id do Usuário para a chave estrangeira utilizada para mapear o relacionamento no banco de dados.
     */
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /**
     * Valor do saque.
     */
    private BigDecimal valor;

    /**
     * Data do saque.
     */
    private LocalDateTime dataSaque;

}
