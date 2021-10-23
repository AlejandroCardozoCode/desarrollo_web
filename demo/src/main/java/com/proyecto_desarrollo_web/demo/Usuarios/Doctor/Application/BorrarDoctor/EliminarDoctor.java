package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.BorrarDoctor;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;

public class EliminarDoctor {

    private DoctorRepositorio repo;

    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;

    public EliminarDoctor(DoctorRepositorio repo){
        this.repo = repo;
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio(this.repo);
    }

    public void execute(String id){
        Doctor doctor = servicioBuscarDoctorDominio.excecute(id);
        repo.delete(doctor);
    }
}
