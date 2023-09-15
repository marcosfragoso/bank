package com.bank.repositories;

import com.bank.domain.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que estende JpaRepository (que já tem métodos pré definidos para criar, ler, alterar e deletar em uma entidade)
 * Utilizada para acessar os dados de Transacao através da chave primária do tipo Long.
 */
public interface TransaacoRepository extends JpaRepository<Transacao, Long> {

}
