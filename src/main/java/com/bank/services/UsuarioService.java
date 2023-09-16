package com.bank.services;

import com.bank.domain.usuario.TipoUsuario;
import com.bank.domain.usuario.Usuario;
import com.bank.dtos.UsuarioDTO;
import com.bank.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Componente de serviço onde contém algumas lógicas do banco, e injetando as dependências.
 */
@Service
public class UsuarioService {
    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao usuarioRepository.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Validando se pode ou não ocorrer a transação de acordo com o usuário e o valor.
     * Comerciantes não podem fazer transações, e usuários comuns precisam ter saldo.
     *
     * @param pagador Usuário pagante da transação.
     * @param valor Valor da transação.
     * @throws Exception Exceções para caso usuário seja comerciante ou não possua saldo.
     */
    public void validaTransacao(Usuario pagador, BigDecimal valor) throws Exception {
        if(pagador.getTipoUsuario() == TipoUsuario.COMERCIANTE) {
            throw new Exception("Comerciantes não são permitidos a realizarem transações.");
        }

        if(pagador.getSaldo().compareTo(valor) < 0) {
            throw new Exception("Usuário pagador não possui saldo suficiente para realizar a transação.");
        }
    }

    public void validaSaque(Usuario usuario, BigDecimal valor) throws Exception {
        if (usuario.getSaldo().compareTo(valor) < 0) {
            throw new Exception("Saldo insuficiente.");
        }
    }

    /**
     * Método para buscar um usuário pelo id.
     *
     * @param id id que deseja buscar o usuário.
     * @return O usuário que contém o id.
     * @throws Exception Exceção para caso não encontre o usuário referente aquele id.
     */
    public Usuario findUsuarioById(Long id) throws Exception {
        return this.usuarioRepository.findUsuarioById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    /**
     * Método para salvar um determinado usuário no repositório.
     *
     * @param usuario O usuário que deseja salvar.
     */
    public void saveUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    /**
     * Método para criar um usuário através de um usuário DTO, nele cria uma instância de Usuário pelas informações do DTO.
     *
     * @param usuarioDTO O usuárioDTO.
     * @return O usuário da classe Usuário.
     */
    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = new Usuario(usuarioDTO);
        this.saveUsuario(novoUsuario);
        return novoUsuario;
    }

    /**
     * Método para buscar todos os Usuários existentes.
     *
     * @return Uma lista de usuários.
     */
    public List<Usuario> getAllUsuarios() {
        return this.usuarioRepository.findAll();
    }
}
