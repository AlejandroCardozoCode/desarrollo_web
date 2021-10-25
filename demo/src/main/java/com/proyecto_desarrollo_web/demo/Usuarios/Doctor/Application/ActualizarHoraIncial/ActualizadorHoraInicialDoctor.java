package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.ActualizarHoraIncial;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event.EventBus;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services.ServicioBuscarDoctorDominio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocHorarioInicial;
import jdk.jfr.Event;

public class ActualizadorHoraInicialDoctor {

    private DoctorRepositorio repo;
    private ServicioBuscarDoctorDominio servicioBuscarDoctorDominio;
    private EventBus e;

    public ActualizadorHoraInicialDoctor(DoctorRepositorio repo){
        this.repo = repo;
        servicioBuscarDoctorDominio = new ServicioBuscarDoctorDominio(this.repo);
    }

    public void execute(Integer horaInicial, String id){
        Doctor doctor = servicioBuscarDoctorDominio.excecute(id);
        doctor.actualizarHoraInicial(new DocHorarioInicial(horaInicial));
        repo.save(doctor);
        this.e.publish(doctor.pullDomainEvents());

    }
}
