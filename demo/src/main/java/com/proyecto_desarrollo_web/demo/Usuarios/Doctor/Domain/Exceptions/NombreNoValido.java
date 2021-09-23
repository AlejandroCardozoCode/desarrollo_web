package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions;

public class NombreNoValido extends RuntimeException {
    public NombreNoValido(String s) {
        super(s);
    }
}
