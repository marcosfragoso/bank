package com.bank.controllers;

import com.bank.domain.deposito.Deposito;
import com.bank.dtos.DepositoDTO;
import com.bank.services.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controllador de Deposito que lida com solicitações http e retorna os dados em formato JSON.
 * Anotation @RequestMapping é usada para mapear uma url específica pro controlador, neste caso /depositos.
 */
@RestController
@RequestMapping("/depositos")
public class DepositoController {
    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao depositoService.
     */
    @Autowired
    private DepositoService depositoService;

    /**
     * Método que mapeia as solicitações POST para a url /depositos criando um novo deposito.
     * Anotation @RequestBody indica que o payload está vindo do corpo da requisição.
     *
     * @param depositoDTO Um objeto DTO do tipo deposito contendo os dados do deposito.
     * @return Um ResponseEntity contendo o novo deposito e o status do http (200 = sucesso)
     * @throws Exception Exceção para caso o saque seja possível.
     */
    @PostMapping
    public ResponseEntity<Deposito> createDeposito(@RequestBody DepositoDTO depositoDTO) throws Exception {
        Deposito novoDeposito = this.depositoService.criaDeposito(depositoDTO);
        return new ResponseEntity<>(novoDeposito, HttpStatus.OK);
    }

    /**
     * Método que mapeia as solicitações GET e lista de todos os depositos da url /depositos.
     *
     * @return Um ResponseEntity contendo a lista de depositos e o status (200 = ok).
     */
    @GetMapping
    public ResponseEntity<List<Deposito>> getAllDepositos() {
        List<Deposito> depositos = this.depositoService.getAllDepositos();
        return new ResponseEntity<>(depositos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Deposito> findById(@PathVariable Long id){
        Deposito obj = depositoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
