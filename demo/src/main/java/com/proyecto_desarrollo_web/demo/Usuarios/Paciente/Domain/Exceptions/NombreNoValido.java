package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions;

public class NombreNoValido extends RuntimeException {
    public NombreNoValido(String s) {
        super(s);
    }
}
