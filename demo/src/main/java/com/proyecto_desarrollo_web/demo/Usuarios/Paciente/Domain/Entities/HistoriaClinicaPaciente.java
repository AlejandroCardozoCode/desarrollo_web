package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities;


import java.util.HashMap;
import java.util.Objects;

public class HistoriaClinicaPaciente {
    private String valoracion;
    private String medicamento;

    private HistoriaClinicaPaciente(){}

    public HistoriaClinicaPaciente(String valoracion, String medicamento) {
        this.valoracion = valoracion;
        this.medicamento = medicamento;
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("valoracion", valoracion);
            put("medicamentos", medicamento);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaClinicaPaciente that = (HistoriaClinicaPaciente) o;
        return Objects.equals(valoracion, that.valoracion) && Objects.equals(medicamento, that.medicamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valoracion, medicamento);
    }
}