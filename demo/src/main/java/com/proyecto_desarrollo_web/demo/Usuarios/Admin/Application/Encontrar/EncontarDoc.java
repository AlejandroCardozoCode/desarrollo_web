package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.Encontrar;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;

public class EncontarDoc {
    private DoctorRepositorio repo;

    private ServicioBuscarDoctorDominio servicioBuscarDoctor;

    public EncontarDoc(DoctorRepositorio repo){
        this.repo = repo;
        servicioBuscarDoctor =  new ServicioBuscarDoctorDominio(this.repo);
    }

    public Doctor econtrar(String id){
        return servicioBuscarDoctor.excecute(id);
    }
}
