package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocCedula;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocId;

import java.util.Optional;

public interface DoctorRepositorio {
    void guardar(Doctor actual);
    Optional<Doctor> encotrar(DocId id);

}
