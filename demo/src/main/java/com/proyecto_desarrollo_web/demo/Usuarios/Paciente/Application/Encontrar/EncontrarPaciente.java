package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.Encontrar;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

public class EncontrarPaciente {

    private PacienteRepositorio repo;

    private ServicioBuscarPaciente servicioBuscarPaciente;

    public EncontrarPaciente(PacienteRepositorio repo){
        this.repo = repo;
        servicioBuscarPaciente = new ServicioBuscarPaciente(repo);
    }

    public Paciente buscar(String id){
        return servicioBuscarPaciente.execute(id);
    }
}
