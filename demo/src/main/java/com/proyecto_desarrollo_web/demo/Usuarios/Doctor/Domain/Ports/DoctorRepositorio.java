package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocId;

import javax.print.Doc;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DoctorRepositorio {
    void save(Doctor actual);
    void update (Doctor doctor);
    Optional<List<Doctor>> all();
    void delete(Doctor doctor);
    Optional<Doctor> find(DocId id);
}
