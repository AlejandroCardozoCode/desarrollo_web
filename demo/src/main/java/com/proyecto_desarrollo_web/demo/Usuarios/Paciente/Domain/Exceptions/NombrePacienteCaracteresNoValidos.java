package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions;

public class NombrePacienteCaracteresNoValidos extends RuntimeException {
    public NombrePacienteCaracteresNoValidos(String s) {
        super(s);
    }
}
