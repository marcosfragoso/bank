package com.bank.repositories;

import com.bank.domain.deposito.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que estende JpaRepository (que já tem métodos pré definidos para criar, ler, alterar e deletar em uma entidade)
 * Utilizada para acessar os dados de Deposito através da chave primária do tipo Long.
 */
public interface DepositoRepository extends JpaRepository<Deposito, Long> {
}
