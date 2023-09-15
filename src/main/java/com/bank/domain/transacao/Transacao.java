package com.bank.domain.transacao;

import com.bank.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representação de uma transação de um banco contendo as seguintes informações: id, usuário pagador, usuário recebedor, valor da transação e a data.
 * A anotation @Entity é utilizada para marcar a classe Transacao como uma entidade JPA representando uma tabela no banco de dados.
 * A anotation @Table é utilizada para especificar o nome da tabela no banco de dados que está associada à entidade JPA.
 * As anotations @Getter, @Setter, @AllArgsConstructor e @EqualsAndHashCode(of = "id") se refere a criação dos getters, setters, contrutores, equals e hashCode automaticamente pela ferramente Lombok.
 */
@Entity(name = "transacoes")
@Table(name = "transacoes")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transacao {
    /**
     * Chave primária da tabela. É um identificador único que é autoincrementado exclusivamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Valor da transação.
     */
    private BigDecimal valor;

    /**
     * O usuário que está efetuando o pagamento da transação.
     * Anotation @ManyToOne referente ao relacionamento de Transação com Usuario. Relacionamento muitos para um, ou seja, um usuário pagador pode ter várias transações e uma transação apenas um usuário pagador.
     * Anotation @JoinColumn usada em conjunto com o ManyToOne que tá usando o id do pagador para a chave estrangeira utilizada para mapear o relacionamento no banco de dados.
     */
    @ManyToOne
    @JoinColumn(name = "pagador_id")
    private Usuario pagador;

    /**
     * O usuário que está recebendo o pagamento da transação.
     * Anotation @ManyToOne referente ao relacionamento de Transação com Usuario. Relacionamento muitos para um, ou seja, um usuário recebedor pode ter várias transações e uma transação apenas um usuário recebedor.
     * Anotation @JoinColumn usada em conjunto com o ManyToOne que tá usando o id do recebedor para a chave estrangeira utilizada para mapear o relacionamento no banco de dados.
     */
    @ManyToOne
    @JoinColumn(name = "recebedor_id")
    private Usuario recebedor;

    /**
     * Data da transação.
     */
    private LocalDateTime dataTransacao;
}
