package com.gabriel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Define a classe de exceção para representar operações matemáticas não suportadas
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    // Número de versão para garantir a consistência durante a serialização
    private static final long serialVersionUID = 1L;
    // Construtor que recebe uma mensagem de erro e a repassa para o construtor da superclasse
    public ResourceNotFoundException(String ex) {
        super(ex);
    }

}
