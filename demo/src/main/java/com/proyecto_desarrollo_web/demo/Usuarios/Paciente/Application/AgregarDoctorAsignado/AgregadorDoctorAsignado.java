package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.AgregarDoctorAsignado;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.AgregarListaPacientes.AgregardorListaPacientes;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities.DoctorAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities.HistoriaClinicaPaciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

import java.util.Optional;

public class AgregadorDoctorAsignado {
    private PacienteRepositorio repoPaciente;
    private DoctorRepositorio repoDoc;
    private ServicioBuscarPaciente servicioBuscarPaciente;
    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;

    public AgregadorDoctorAsignado(PacienteRepositorio repo, DoctorRepositorio repoDoc){
        this.repoPaciente = repo;
        this.repoDoc = repoDoc;
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repoPaciente);
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio((this.repoDoc));
    }

    public void execute(String idPaciente, String idDoctorAsignado)
    {
        Paciente paciente = servicioBuscarPaciente.execute(idPaciente);
        Doctor docPrincipal = servicioBuscarDoctorDominio.excecute(idDoctorAsignado);
        DoctorAsignado doc = docPrincipal.crearDoctorAsignado();
        Optional<DoctorAsignado> opt = Optional.of(doc);
        paciente.agregarDoctorAsignado(opt);
        repoPaciente.save(paciente);
    }
}
