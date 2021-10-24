package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain;

import com.proyecto_desarrollo_web.demo.Shared.Entities.HistoriaClinica;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities.PacienteAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities.DoctorAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities.HistoriaClinicaPaciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Paciente {
    private PacienteId id;
    private PacienteNombre nombre;
    private PacienteAnimal animal;
    private PacienteRaza raza;
    private PacienteEdad edad;
    private PacienteIdCliente idCliente;
    private Optional<DoctorAsignado> doctor;
    private Optional<HistoriaClinicaPaciente> historiaClinicaPaciente;


    private Paciente (){}

    public Paciente(PacienteId id, PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteIdCliente idCliente) {
        this.id = id;
        this.nombre = nombre;
        this.animal = animal;
        this.raza = raza;
        this.edad = edad;
        this.idCliente = idCliente;
        this.doctor = Optional.empty();
        this.historiaClinicaPaciente = Optional.empty();
    }

    public static  Paciente crear(PacienteId id, PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteIdCliente idCliente){
        Paciente pacienteNuevo = new Paciente(id,nombre,animal, raza, edad, idCliente);
        return pacienteNuevo;
    }

    public void agregarHistoriClinica(Optional<HistoriaClinicaPaciente>historiaClinica) {
        this.historiaClinicaPaciente = historiaClinica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(nombre, paciente.nombre) && Objects.equals(animal, paciente.animal) && Objects.equals(raza, paciente.raza) && Objects.equals(edad, paciente.edad) && Objects.equals(idCliente, paciente.idCliente) && Objects.equals(historiaClinicaPaciente, paciente.historiaClinicaPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, animal, raza, edad, idCliente, historiaClinicaPaciente);
    }


    public void agregarDoctorAsignado(Optional<DoctorAsignado> opt) {
        this.doctor = opt;
    }

    public PacienteAsignado crearPacienteAsignado() {
        PacienteAsignado nuevo = new PacienteAsignado(this.id.toString(),this.animal.toString(), this.idCliente.toString());
        return nuevo;
    }
}
