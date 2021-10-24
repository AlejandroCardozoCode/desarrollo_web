package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities;

import java.util.HashMap;
import java.util.Objects;

public class PacienteAsignado {

    String idPaciente;
    String animal;
    String idCliente;


    private PacienteAsignado(){}

    public PacienteAsignado(String idPaciente, String animla, String idCliente) {
        this.idPaciente = idPaciente;
        this.animal = animla;
        this.idCliente = idCliente;
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("idPaciente",idPaciente);
            put("animal",animal);
            put("idCliente",idCliente);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteAsignado that = (PacienteAsignado) o;
        return Objects.equals(idPaciente, that.idPaciente) && Objects.equals(animal, that.animal) && Objects.equals(idCliente, that.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaciente, animal, idCliente);
    }
}
