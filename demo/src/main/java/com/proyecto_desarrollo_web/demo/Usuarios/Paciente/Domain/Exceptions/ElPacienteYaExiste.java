package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions;

public class ElPacienteYaExiste extends RuntimeException{
    public ElPacienteYaExiste(String s) {
        super(s);
    }
}
