package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.CambiarContra;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocContrasenna;

import javax.print.Doc;

public class CambiarContra {

    private DoctorRepositorio repo;

    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;

    public CambiarContra(DoctorRepositorio repo){
        this.repo = repo;
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio(this.repo);
    }

    public void execute(String id, String nuevaContra){
        Doctor doctor = servicioBuscarDoctorDominio.excecute(id);
        doctor.actualizarContra(new DocContrasenna(nuevaContra));
    }
}
