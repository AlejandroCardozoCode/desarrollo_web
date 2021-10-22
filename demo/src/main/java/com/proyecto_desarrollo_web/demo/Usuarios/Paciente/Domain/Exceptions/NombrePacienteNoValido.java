package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions;

public class NombrePacienteNoValido extends RuntimeException {
    public NombrePacienteNoValido(String s) {
        super(s);
    }
}
