package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Services;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.idDoctorNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocId;

import java.util.Optional;

public class ServicioBuscarDoctorDominio {

    private DoctorRepositorio repo;

    public ServicioBuscarDoctorDominio(DoctorRepositorio repo){
        this.repo = repo;
    }

    public Doctor excecute(String id){
        Optional<Doctor> docOptional = repo.encotrar(new DocId(id));
        if(docOptional.isEmpty()) {
            throw new idDoctorNoEncontrado("El id del doctor no ha sido encontrado");
        }
        return docOptional.get();
    }
}
