package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.AgregarHistoriaClinica;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Shared.Entities.HistoriaClinica;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

public class AgregadorHistoria {

    private DoctorRepositorio repo;
    private PacienteRepositorio repoPaciente;

    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;
    private ServicioBuscarPaciente servicioBuscarPaciente;

    public AgregadorHistoria(DoctorRepositorio repo, PacienteRepositorio repoPaciente){
        this.repo = repo;
        this.repoPaciente = repoPaciente;
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio(this.repo);
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repoPaciente);
    }

    public void execute(String idDoctor, String idPaciente, Integer horaCita, Integer diaCita, Integer mesCita, String nombrePaciente, String valoracion)
    {
        Doctor doc = servicioBuscarDoctorDominio.excecute(idDoctor);
        Paciente paciente = servicioBuscarPaciente.execute(idPaciente);

        HistoriaClinica citaNueva = new HistoriaClinica(idDoctor,idPaciente,horaCita, diaCita,mesCita,nombrePaciente, valoracion);
        doc.agregarCita(citaNueva);
        repo.save(doc);
        paciente.agregarHistoriaClinica(citaNueva);
        repoPaciente.guardar(paciente);

    }
}
