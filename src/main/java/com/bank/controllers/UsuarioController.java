package com.bank.controllers;

import com.bank.domain.usuario.Usuario;
import com.bank.dtos.UsuarioDTO;
import com.bank.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controllador de Usuário que lida com solicitações http e retorna os dados em formato JSON.
 * Anotation @RequestMapping é usada para mapear uma url específica pro controlador, neste caso /usuarios.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    /**
     * Anotation @Autowired injeta as dependências em seu serviço com acesso ao usuarioService.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Método que mapeia as solicitações POST para a url /usuarios criando um novo usuário.
     * Anotation @RequestBody indica que o payload está vindo do corpo da requisição.
     *
     * @param usuario Um objeto UsuarioDTO contendo os dados do novo usuário.
     * @return Um ResponseEntity contendo o novo usuário criado e o status do http (201 = sucesso).
     */
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuario) {
        Usuario novoUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    /**
     * Método que mapeia as solicitações GET e lista todos os usuários da url /usuários.
     *
     * @return Um ResponseEntity contendo a lista de usuários e o status (200 = ok).
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> gettAllUsuarios() {
        List<Usuario> usuarios = this.usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
