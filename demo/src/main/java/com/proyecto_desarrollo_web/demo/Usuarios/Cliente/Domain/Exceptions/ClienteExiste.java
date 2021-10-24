package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions;

public class ClienteExiste extends RuntimeException {
    public ClienteExiste(String s) {
        super((s));
    }
}
