package com.bank.controllers;

import com.bank.domain.saque.Saque;
import com.bank.dtos.SaqueDTO;
import com.bank.services.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controllador de Saque que lida com solicitações http e retorna os dados em formato JSON.
 * Anotation @RequestMapping é usada para mapear uma url específica pro controlador, neste caso /saques.
 */
@RestController
@RequestMapping("/saques")
public class SaqueController {

    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao saqueService.
     */
    @Autowired
    private SaqueService saqueService;

    /**
     * Método que mapeia as solicitações POST para a url /saques criando um novo saque.
     * Anotation @RequestBody indica que o payload está vindo do corpo da requisição.
     *
     * @param saqueDTO Um objeto DTO do tipo saque contendo os dados do saque.
     * @return Um ResponseEntity contendo o novo saque e o status do http (200 = sucesso)
     * @throws Exception Exceção para caso o saque seja possível.
     */
    @PostMapping
    public ResponseEntity<Saque> createSaque(@RequestBody SaqueDTO saqueDTO) throws Exception {
        Saque novoSaque = this.saqueService.criaSaque(saqueDTO);
        return new ResponseEntity<>(novoSaque, HttpStatus.OK);
    }

    /**
     * Método que mapeia as solicitações GET e lista de todos os saques da url /saques.
     *
     * @return Um ResponseEntity contendo a lista de saques e o status (200 = ok).
     */
    @GetMapping
    public ResponseEntity<List<Saque>> getAllSaques() {
        List<Saque> saques = this.saqueService.getAllSaques();
        return new ResponseEntity<>(saques, HttpStatus.OK);
    }

    /**
     * Método que mapeia solicitação GET e lista um saque pelo id passado
     *
     * @param id O id do saque.
     * @return O objeto saque.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Saque> findById(@PathVariable Long id){
        Saque obj = saqueService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
