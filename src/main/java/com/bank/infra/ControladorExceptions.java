package com.bank.infra;

import com.bank.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controlador criado para lidar com as exceções do banco.
 */
@ControllerAdvice
public class ControladorExceptions {
    /**
     * Manipula exceções do tipo DataIntegrityViolationException que podem ocorrer quando um usuário está sendo cadastrado, mas já existe um com os mesmos dados.
     *
     * @param exception Uma instância da exceção DataIntegrityViolationException.
     * @return ResponseEntity contendo um objeto ExceptionDTO com uma mensagem de erro e código de status "400 Bad Request".
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity usuariosDuplicados(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já está cadastrado.", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    /**
     * Manipula exceções do tipo EntityNotFoundException que podem ocorrer quando uma entidade não é encontrada durante uma operação de busca ou consulta.
     *
     * @param exception Uma instância da exceção EntityNotFoundException.
     * @return ResponseEntity com um código de status "404 Not Found" indicando que a entidade não foi encontrada.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entidadeNaoEncontrada(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    /**
     * Manipula exceções do tipo Exception que podem ocorrer como um tratamento de último recurso para quaisquer exceções não tratadas anteriormente na aplicação.
     *
     * @param exception Uma instância da exceção Exception que não foi tratada anteriormente.
     * @return ResponseEntity com um código de status "500 Internal Server Error" e uma mensagem de erro que descreve o problema geral.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity erroGeral(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

}
