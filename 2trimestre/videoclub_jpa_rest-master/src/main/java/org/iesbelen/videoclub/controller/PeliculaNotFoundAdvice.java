package org.iesbelen.videoclub.controller;

import org.iesbelen.videoclub.exception.PeliculaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PeliculaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PeliculaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String peliculaNotFoundHandler(PeliculaNotFoundException peliculaNotFoundException) {
        return peliculaNotFoundException.getMessage();
    }
}
