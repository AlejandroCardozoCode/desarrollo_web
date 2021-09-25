package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.ConsutlarCitas;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities.Citas;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

import java.util.List;

public class CitasPaciente {

    private PacienteRepositorio repo;

    private ServicioBuscarPaciente servicioBuscarPaciente;

    public CitasPaciente(PacienteRepositorio repo){
        this.repo = repo;
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repo);
    }

    public List<Citas> execute(String id){
        Paciente paciente = servicioBuscarPaciente.execute(id);
        return paciente.verCitasPaciente();
    }
}
