package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.ConsutlarHistorialMedico;

import com.proyecto_desarrollo_web.demo.Shared.Entities.HistoriaClinica;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

import java.util.List;

public class HistorialMedicoPaciente {

    private PacienteRepositorio repo;

    private ServicioBuscarPaciente servicioBuscarPaciente;

    public HistorialMedicoPaciente(PacienteRepositorio repo){
        this.repo = repo;
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repo);
    }

    public List<HistoriaClinica> execute(String id){
        Paciente paciente = servicioBuscarPaciente.execute(id);
        return paciente.verHistorialMedicoPaciente();
    }
}
