package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.CrearDoctor;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.DocAlreadyExist;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.*;

import java.util.Optional;

public class CrearDoctor {

    private DoctorRepositorio repositorio;

    public CrearDoctor(DoctorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void execute(String id, String nombre,Integer cedula, Integer horarioInicial, Integer horarioFinal, String usuario , String contra){
        this.validate(id);
        Doctor doctor = Doctor.Create(new DocId(id),new DocNombre(nombre), new DocCedula(cedula), new DocHorarioInicial(horarioInicial), new DocHorarioFinal(horarioFinal), new DocUsuario(usuario), new DocContrasenna(contra));
        repositorio.save(doctor);
    }
    private void validate(String docId)
    {
        Optional<Doctor> doctor = repositorio.find(new DocId(docId));
        if(doctor.isPresent())
        {
            throw new DocAlreadyExist("El doctor con id:" + docId + "ya existe");
        }
    }
}
