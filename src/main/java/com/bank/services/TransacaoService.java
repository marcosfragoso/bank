package com.bank.services;

import com.bank.domain.transacao.Transacao;
import com.bank.domain.usuario.Usuario;
import com.bank.dtos.TransacaoDTO;
import com.bank.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Componente de serviço onde contém algumas lógicas do banco, e injetando as dependências.
 */
@Service
public class TransacaoService {
    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao usuarioService.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao transacaoRepository.
     */
    @Autowired
    private TransacaoRepository transacaoRepository;

    /**
     * Método para criar uma transação através de um DTO de uma transação, que é uma forma simplificada de transação.
     *
     * @return A transação criada.
     * @param transacao A transaçãoDTO.
     * @throws Exception Exceção para caso o usuário não seja encontrado, ou não esteja validado para efetuar a transação.
     */
    public Transacao criaTransacao(TransacaoDTO transacao) throws Exception {
        Usuario pagador = this.usuarioService.findUsuarioById(transacao.pagadorId());
        Usuario recebedor = this.usuarioService.findUsuarioById(transacao.recebedorId());

        usuarioService.validaTransacao(pagador, transacao.valor());

        Transacao novaTransacao = new Transacao();
        novaTransacao.setValor(transacao.valor());
        novaTransacao.setPagador(pagador);
        novaTransacao.setRecebedor(recebedor);
        novaTransacao.setDataTransacao(LocalDateTime.now());

        pagador.setSaldo(pagador.getSaldo().subtract(transacao.valor()));
        recebedor.setSaldo(recebedor.getSaldo().add(transacao.valor()));

        this.transacaoRepository.save(novaTransacao);
        this.usuarioService.saveUsuario(pagador);
        this.usuarioService.saveUsuario(recebedor);

        return novaTransacao;
    }

    /**
     * Método para buscar todas as Transações existentes.
     *
     * @return Uma lista de transações.
     */
    public List<Transacao> getAllTransacoes() {
        return this.transacaoRepository.findAll();
    }

}
