package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.ActualizarHoraFinal;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocHorarioFinal;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocHorarioInicial;

public class ActualizarHoraFianlDoctor {


    private DoctorRepositorio repo;
    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;

    public ActualizarHoraFianlDoctor (DoctorRepositorio repo){
        this.repo = repo;
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio(this.repo);
    }

    public void execute(Integer horaFinal, String id){
        Doctor doctor = servicioBuscarDoctorDominio.excecute(id);
        doctor.actualizarHoraFinal(new DocHorarioFinal(horaFinal));
        repo.guardar(doctor);
    }
}
