package org.iesbelen.videoclub.controller;

import org.iesbelen.videoclub.exception.TarjetaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TarjetaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TarjetaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tarjetaNotFoundHandler(TarjetaNotFoundException tarjetaNotFoundException) {
        return tarjetaNotFoundException.getMessage();
    }
}
