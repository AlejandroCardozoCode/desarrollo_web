package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions;

public class NombreClienteVacio extends RuntimeException {
    public NombreClienteVacio(String s) {
        super(s);
    }
}
