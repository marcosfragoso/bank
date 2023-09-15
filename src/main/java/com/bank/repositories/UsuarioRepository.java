package com.bank.repositories;

import com.bank.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /**
     * Método que busca um determinado usuário pelo cpf.
     * @param cpf cpf que deseja buscar.
     * @return Retorna o usuário caso encontrado.
     */
    Optional<Usuario> findUsuarioByCpf(String cpf);

    /**
     * Método que busca um determinado usuário pelo id.
     * @param id id que deseja buscar.
     * @return Retorna o usuário caso encontrado.
     */
    Optional<Usuario> findUsuarioById(Long id);
}
