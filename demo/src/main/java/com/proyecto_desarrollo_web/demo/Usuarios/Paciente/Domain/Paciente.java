package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.*;

public class Paciente {
    private PacienteNombre nombre;
    private PacienteAnimal animal;
    private PacienteRaza raza;
    private PacienteEdad edad;
    private PacienteValoracion valoracion;
    private PacienteCC ccDuenio;

    public Paciente(PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteValoracion valoracion, PacienteCC ccDuenio) {
        this.nombre = nombre;
        this.animal = animal;
        this.raza = raza;
        this.edad = edad;
        this.valoracion = valoracion;
        this.ccDuenio = ccDuenio;
    }

    public static  Paciente Create(PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteValoracion valoracion, PacienteCC ccDuenio){
        Paciente pacienteNuevo = new Paciente(nombre,animal, raza, edad, valoracion, ccDuenio);
        return pacienteNuevo;
    }
}
