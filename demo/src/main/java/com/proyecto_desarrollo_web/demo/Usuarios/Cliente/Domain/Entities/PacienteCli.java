package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities;

import com.proyecto_desarrollo_web.demo.Shared.Entities.HistoriaClinica;

import java.util.HashMap;
import java.util.Objects;

public class PacienteCli {
    private String idPaciente;
    private String animal;
    private String raza;
    private Integer edad;

    public PacienteCli(String idPaciente, String animal, String raza, Integer edad) {
        this.idPaciente = idPaciente;
        this.animal = animal;
        this.raza = raza;
        this.edad = edad;
    }
    public  HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("idPaciente",idPaciente);
            put("animal",animal);
            put("raza",raza);
            put("edad",edad);
        }};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteCli pacientes = (PacienteCli) o;
        return idPaciente.equals(pacientes.idPaciente) && animal.equals(pacientes.animal) && raza.equals(pacientes.raza) && edad.equals(pacientes.edad);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idPaciente, animal, raza, edad);
    }
}
