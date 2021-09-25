package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions;

public class CarritoComprasVacio extends RuntimeException {
    public CarritoComprasVacio(String s) {
        super((s));
    }
}
