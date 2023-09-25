package com.bank.services;

import com.bank.domain.deposito.Deposito;
import com.bank.domain.usuario.Usuario;
import com.bank.dtos.DepositoDTO;
import com.bank.repositories.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Componente de serviço onde contém algumas lógicas do banco, e injetando as dependências.
 */
@Service
public class DepositoService {
    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao usuarioService.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao depositoRepository.
     */
    @Autowired
    private DepositoRepository depositoRepository;

    /**
     * Método para criar um deposito através de um DTO de um deposito, que é uma forma simplificada de deposito.
     *
     * @param depositoDTO O depositoDTO.
     * @return O deposito criado.
     * @throws Exception Exceção para caso o usuário não seja encontrado.
     */
    public Deposito criaDeposito(DepositoDTO depositoDTO) throws Exception {
        Usuario usuario = this.usuarioService.findUsuarioById(depositoDTO.usuarioId());

        Deposito novoDeposito = new Deposito();
        novoDeposito.setUsuario(usuario);
        novoDeposito.setValor(depositoDTO.valor());
        novoDeposito.setDataDeposito(LocalDateTime.now());

        usuario.setSaldo(usuario.getSaldo().add(depositoDTO.valor()));

        this.depositoRepository.save(novoDeposito);
        this.usuarioService.saveUsuario(usuario);

        return novoDeposito;
    }

    /**
     * Método para buscar todos os depositos existentes.
     *
     * @return Uma lista de depositos.
     */
    public List<Deposito> getAllDepositos() {
        return this.depositoRepository.findAll();
    }

    /**
     * Método para buscar um deposito pelo id.
     *
     * @param id O id do deposito.
     * @return O objeto deposito.
     */
    public Deposito findById(Long id) {
        Optional<Deposito> obj = depositoRepository.findById(id);
        return obj.get();
    }
}
