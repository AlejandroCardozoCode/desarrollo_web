package com.proyecto_desarrollo_web.demo.Shared.Entities;


import java.util.Objects;

public class HistoriaClinica {
    private String idDoctor;
    private String idPaciente;
    private Integer horaCita;
    private Integer diaCita;
    private Integer mesCita;
    private String nombrePacienteMascota;
    private String valoracion;

    public HistoriaClinica(String idDoctor, String idPaciente, Integer horaCita, Integer diaCita, Integer mesCita, String nombrePacienteMascota, String valoracion) {
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
        this.horaCita = horaCita;
        this.diaCita = diaCita;
        this.mesCita = mesCita;
        this.nombrePacienteMascota = nombrePacienteMascota;
        this.valoracion = valoracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaClinica citas = (HistoriaClinica) o;
        return idDoctor.equals(citas.idDoctor) && idPaciente.equals(citas.idPaciente) && horaCita.equals(citas.horaCita) && diaCita.equals(citas.diaCita) && mesCita.equals(citas.mesCita) && nombrePacienteMascota.equals(citas.nombrePacienteMascota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor, idPaciente, horaCita, diaCita, mesCita, nombrePacienteMascota);
    }
}
