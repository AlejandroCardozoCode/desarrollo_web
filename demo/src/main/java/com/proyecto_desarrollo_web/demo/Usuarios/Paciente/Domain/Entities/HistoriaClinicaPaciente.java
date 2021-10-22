package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities;


import java.util.HashMap;
import java.util.Objects;

public class HistoriaClinicaPaciente {
    private String idDoctor;
    private String idPaciente;
    private Integer horaCita;
    private Integer diaCita;
    private Integer mesCita;
    private String nombrePacienteMascota;
    private String valoracion;

    private HistoriaClinicaPaciente(){}

    public HistoriaClinicaPaciente(String idDoctor, String idPaciente, Integer horaCita, Integer diaCita, Integer mesCita, String nombrePacienteMascota, String valoracion) {
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
        this.horaCita = horaCita;
        this.diaCita = diaCita;
        this.mesCita = mesCita;
        this.nombrePacienteMascota = nombrePacienteMascota;
        this.valoracion = valoracion;
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("idDoctor",idDoctor);
            put("idPaciente",idPaciente);
            put("horaCita",horaCita);
            put("diaCita",diaCita);
            put("mesCita",mesCita);
            put("nombrePacienteMascota",nombrePacienteMascota);
            put("valoracion", valoracion);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaClinicaPaciente that = (HistoriaClinicaPaciente) o;
        return Objects.equals(idDoctor, that.idDoctor) && Objects.equals(idPaciente, that.idPaciente) && Objects.equals(horaCita, that.horaCita) && Objects.equals(diaCita, that.diaCita) && Objects.equals(mesCita, that.mesCita) && Objects.equals(nombrePacienteMascota, that.nombrePacienteMascota) && Objects.equals(valoracion, that.valoracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor, idPaciente, horaCita, diaCita, mesCita, nombrePacienteMascota, valoracion);
    }
}