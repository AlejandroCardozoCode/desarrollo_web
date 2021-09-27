package com.proyecto_desarrollo_web.demo.Shared.Entities;


import java.util.Objects;

public class Citas {
    private String idDoctor;
    private String idPaciente;
    private Integer hotaCita;
    private Integer diaCita;
    private Integer mesCita;
    private String nombrePacienteMascota;

    public Citas(String idDoctor, String idPaciente, Integer hotaCita, Integer diaCita, Integer mesCita, String nombrePacienteMascota) {
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
        this.hotaCita = hotaCita;
        this.diaCita = diaCita;
        this.mesCita = mesCita;
        this.nombrePacienteMascota = nombrePacienteMascota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citas citas = (Citas) o;
        return idDoctor.equals(citas.idDoctor) && idPaciente.equals(citas.idPaciente) && hotaCita.equals(citas.hotaCita) && diaCita.equals(citas.diaCita) && mesCita.equals(citas.mesCita) && nombrePacienteMascota.equals(citas.nombrePacienteMascota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor, idPaciente, hotaCita, diaCita, mesCita, nombrePacienteMascota);
    }
}
