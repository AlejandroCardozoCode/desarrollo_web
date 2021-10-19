package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain;

import com.proyecto_desarrollo_web.demo.Shared.Entities.HistoriaClinica;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public class Paciente {
    private PacienteId id;
    private PacienteNombre nombre;
    private PacienteAnimal animal;
    private PacienteRaza raza;
    private PacienteEdad edad;
    private PacienteIdCliente idCliente;
    private Optional<List<HistoriaClinica>> historiaClinicaPaciente;


    public Paciente(PacienteId id, PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteIdCliente idCliente) {
        this.id = id;
        this.nombre = nombre;
        this.animal = animal;
        this.raza = raza;
        this.edad = edad;
        this.idCliente = idCliente;
        this.historiaClinicaPaciente = Optional.empty();
    }

    public static  Paciente crear(PacienteId id, PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteIdCliente idCliente){
        Paciente pacienteNuevo = new Paciente(id,nombre,animal, raza, edad, idCliente);
        return pacienteNuevo;
    }

    public List<HistoriaClinica> verHistorialMedicoPaciente(){
        return this.historiaClinicaPaciente.get();
    }

    public void agregarHistoriaClinica(HistoriaClinica cita)
    {
        this.historiaClinicaPaciente.get().add(cita);
    }


}
