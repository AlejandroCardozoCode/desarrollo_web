package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions;

public class DocAlreadyExist extends RuntimeException {
    public DocAlreadyExist(String s) {
        super(s);
    }
}
