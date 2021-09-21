package Usuarios.Doctor.Domain.Entities;


import java.util.Objects;

public class Citas {
    private Integer cedulaDoctor;
    private Integer cedulaDuenio;
    private Integer hotaCita;
    private Integer diaCita;
    private Integer mesCita;
    private String nombrePacienteMascota;

    public Citas(Integer cedulaDoctor, Integer cedulaDuenio, Integer hotaCita, Integer diaCita, Integer mesCita, String nombrePacienteMascota) {
        this.cedulaDoctor = cedulaDoctor;
        this.cedulaDuenio = cedulaDuenio;
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
        return cedulaDoctor.equals(citas.cedulaDoctor) && cedulaDuenio.equals(citas.cedulaDuenio) && hotaCita.equals(citas.hotaCita) && diaCita.equals(citas.diaCita) && mesCita.equals(citas.mesCita) && nombrePacienteMascota.equals(citas.nombrePacienteMascota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedulaDoctor, cedulaDuenio, hotaCita, diaCita, mesCita, nombrePacienteMascota);
    }
}
