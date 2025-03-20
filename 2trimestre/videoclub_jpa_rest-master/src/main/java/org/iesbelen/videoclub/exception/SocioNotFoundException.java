package org.iesbelen.videoclub.exception;

public class SocioNotFoundException extends RuntimeException {
    public SocioNotFoundException(Long id) {
        super("Not found Socio with id: " + id);
    }
}
