package Usuarios.Doctor.Domain;

import Usuarios.Doctor.Domain.Entities.Paciente;
import Usuarios.Doctor.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public class Doctor {
    private DocNombre nombre;
    private DocHorarioInicial horarioInicial;
    private DocHorarioFinal horarioFinal;
    private DocEstudios estudios;
    private Optional<List<Paciente>> arregloPacientes;

    public Doctor(DocNombre nombre, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocEstudios estudios, Optional<List<Paciente>> arregloPacientes) {
        this.nombre = nombre;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.estudios = estudios;
        this.arregloPacientes = arregloPacientes;
    }

    public static Doctor Create(DocNombre nombre, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocEstudios estudios ){
        Doctor doctoNuevo = new Doctor(nombre,horarioInicial, horarioFinal,estudios, Optional.empty());
        return doctoNuevo;
    }
}
