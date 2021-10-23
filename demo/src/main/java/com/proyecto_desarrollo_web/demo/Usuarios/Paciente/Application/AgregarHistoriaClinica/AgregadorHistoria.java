package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.AgregarHistoriaClinica;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities.HistoriaClinicaPaciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

import java.util.Optional;

public class AgregadorHistoria {

    private PacienteRepositorio repoPaciente;
    private ServicioBuscarPaciente servicioBuscarPaciente;

    public AgregadorHistoria(PacienteRepositorio repo){
        this.repoPaciente = repo;
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repoPaciente);
    }

    public void execute(String idPaciente, String valoracion, String medicamentos)
    {
        Paciente paciente = servicioBuscarPaciente.execute(idPaciente);
        HistoriaClinicaPaciente historiaClinica = new HistoriaClinicaPaciente(valoracion, medicamentos);
        Optional<HistoriaClinicaPaciente> opt = Optional.of(historiaClinica);
        paciente.agregarHistoriClinica(opt);
        repoPaciente.save(paciente);
    }
}
