package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.AgregarCita;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Shared.Entities.Citas;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

public class AgregadorCita {

    private DoctorRepositorio repo;
    private PacienteRepositorio repoPaciente;

    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;
    private ServicioBuscarPaciente servicioBuscarPaciente;

    public AgregadorCita(DoctorRepositorio repo, PacienteRepositorio repoPaciente){
        this.repo = repo;
        this.repoPaciente = repoPaciente;
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio(this.repo);
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repoPaciente);
    }

    public void execute(String idDoctor, String idPaciente, Integer horaCita, Integer diaCita, Integer mesCita, String nombrePaciente)
    {
        Doctor doc = servicioBuscarDoctorDominio.excecute(idDoctor);
        Paciente paciente = servicioBuscarPaciente.execute(idPaciente);

        Citas citaNueva = new Citas(idDoctor,idPaciente,horaCita, diaCita,mesCita,nombrePaciente);
        doc.agregarCita(citaNueva);
        repo.guardar(doc);
        paciente.agregarCita(citaNueva);
        repoPaciente.guardar(paciente);

    }
}
