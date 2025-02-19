package org.iesbelen.controlador;

import org.iesbelen.excepcion.MiExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Manejo global de excepciones
@ControllerAdvice
public class ErrorController {

    // Captura excepciones personalizadas
    @ExceptionHandler(MiExcepcion.class)
    public String handleMiExcepcion(Model model, MiExcepcion ex) {
        model.addAttribute("traza", ex.getMessage());
        return "error-excepcion";
    }

    // Captura excepciones genéricas
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(Model model, RuntimeException ex) {
        model.addAttribute("traza", ex.getMessage());
        return "error";
    }
}
