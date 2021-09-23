package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions;


public class CedulaInvalida extends RuntimeException {
    public CedulaInvalida(String s) {
        super(s);
    }
}
