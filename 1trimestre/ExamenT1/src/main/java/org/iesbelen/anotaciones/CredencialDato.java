package org.iesbelen.anotaciones;

import java.util.ArrayList;
import java.util.List;

public class CredencialDato {
    private String usuario;
    private String clave;

    public CredencialDato(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

}
