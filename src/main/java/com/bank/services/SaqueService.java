package com.bank.services;

import com.bank.domain.saque.Saque;
import com.bank.domain.transacao.Transacao;
import com.bank.domain.usuario.Usuario;
import com.bank.dtos.SaqueDTO;
import com.bank.repositories.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Componente de serviço onde contém algumas lógicas do banco, e injetando as dependências.
 */
@Service
public class SaqueService {
    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao usuarioService.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao saqueRepository.
     */
    @Autowired
    private SaqueRepository saqueRepository;

    /**
     * Método para criar um saque através de um DTO de um saque, que é uma forma simplificada de saque.
     *
     * @param saqueDTO O saqueDTO.
     * @return O saque criado.
     * @throws Exception Exceção para caso o usuário não seja encontrado, ou não esteja validado para efetuar o saque.
     */
    public Saque criaSaque(SaqueDTO saqueDTO) throws Exception {
        Usuario usuario = this.usuarioService.findUsuarioById(saqueDTO.usuarioId());

        usuarioService.validaSaque(usuario, saqueDTO.valor());

        Saque novoSaque = new Saque();
        novoSaque.setUsuario(usuario);
        novoSaque.setValor(saqueDTO.valor());
        novoSaque.setDataSaque(LocalDateTime.now());

        usuario.setSaldo(usuario.getSaldo().subtract(saqueDTO.valor()));

        this.saqueRepository.save(novoSaque);
        this.usuarioService.saveUsuario(usuario);

        return novoSaque;
    }

    /**
     * Método para buscar todos os saques existentes.
     *
     * @return Uma lista de saques.
     */
    public List<Saque> getAllSaques() {
        return this.saqueRepository.findAll();
    }
}
