package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.AgregarListaPacientes;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

public class AgregardorListaPacientes {

    private PacienteRepositorio repo;
    private DoctorRepositorio repoDoc;

    private ServicioBuscarPaciente servicioBuscarPaciente;

    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;
    public AgregardorListaPacientes(PacienteRepositorio repo, DoctorRepositorio repoDoc){
        this.repo = repo;
        this.repoDoc = repoDoc;
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repo);
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio(this.repoDoc);
    }

    public void execute(String id, String idDoc){
        Paciente paciente = servicioBuscarPaciente.execute(id);
        Doctor doctor = servicioBuscarDoctorDominio.excecute(idDoc);
        doctor.agregarPacienteListaPacientes(paciente);
        repoDoc.guardar(doctor);

    }
}
