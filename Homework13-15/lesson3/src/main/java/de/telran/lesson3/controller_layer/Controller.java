package de.telran.lesson3.controller_layer;

import de.telran.lesson3.exception_layer.Response;
import de.telran.lesson3.exception_layer.exceptions.FirstTestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface Controller {
    @ExceptionHandler(FirstTestException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    default Response handleException(FirstTestException e){
        return new Response(e.getMessage());
    }
}
