package com.bank.controllers;

import com.bank.domain.transacao.Transacao;
import com.bank.dtos.TransacaoDTO;
import com.bank.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controllador de Transação que lida com solicitações http e retorna os dados em formato JSON.
 * Anotation @RequestMapping é usada para mapear uma url específica pro controlador, neste caso /transacoes.
 */
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao transacaoService.
     */
    @Autowired
    private TransacaoService transacaoService;

    /**
     * Método que mapeia as solicitações POST para a url /transacoes criando uma nova transacao.
     * Anotation @RequestBody indica que o payload está vindo do corpo da requisição.
     *
     * @param transacao Um objeto DTO do tipo transacao contendo os dados da transaçao.
     * @return Um ResponseEntity contendo a nova transação e o status do http (200 = sucesso).
     * @throws Exception Exceção para caso a transação não seja possível.
     */
    @PostMapping
    public ResponseEntity<Transacao> createTransacao(@RequestBody TransacaoDTO transacao) throws Exception {
        Transacao novaTransacao = this.transacaoService.criaTransacao(transacao);
        return new ResponseEntity<>(novaTransacao, HttpStatus.OK);
    }
}