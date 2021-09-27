package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.idPacienteNoEncontrado;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.PacienteId;

import java.util.Optional;

public class ServicioBuscarPaciente {
    private PacienteRepositorio repo;

    public ServicioBuscarPaciente(PacienteRepositorio repo){
        this.repo = repo;
    }

    public Paciente execute(String id){
        Optional<Paciente> pacienteOptional = repo.buscar(new PacienteId((id)));
        if(pacienteOptional.isEmpty()){
            throw new idPacienteNoEncontrado("El id del paciente no ha sido encontrado");
        }
        return pacienteOptional.get();
    }
}
