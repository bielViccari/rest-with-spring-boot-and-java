package com.gabriel.exceptions.handler;

import com.gabriel.exceptions.ExceptionResponse;
import com.gabriel.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// Anotação indicando que esta classe é um controlador de aconselhamento para manipular exceções
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // Método para lidar com exceções do tipo Exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        // Cria uma resposta padronizada de exceção
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        // Retorna a resposta com o código de status HTTP INTERNAL_SERVER_ERROR (500)
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Método para lidar com exceções específicas do tipo UnsupportedMathOperationException
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request) {
        // Cria uma resposta padronizada de exceção
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        // Retorna a resposta com o código de status HTTP BAD_REQUEST (400)
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}