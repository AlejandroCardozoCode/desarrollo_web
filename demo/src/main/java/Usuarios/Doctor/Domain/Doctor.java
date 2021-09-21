package Usuarios.Doctor.Domain;

import Usuarios.Doctor.Domain.Entities.Citas;
import Usuarios.Doctor.Domain.Entities.Paciente;
import Usuarios.Doctor.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public class Doctor {
    private DocNombre nombre;
    private DocCedula cedula;
    private DocHorarioInicial horarioInicial;
    private DocHorarioFinal horarioFinal;
    private DocEstudios estudios;
    private Optional<List<Paciente>> arregloPacientes;
    private Optional<List<Citas>> arregloCitas;

    public Doctor(DocNombre nombre, DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocEstudios estudios, Optional<List<Paciente>> empty) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.estudios = estudios;
        this.arregloPacientes = arregloPacientes;
        this.arregloCitas = arregloCitas;
    }

    public static Doctor Create(DocNombre nombre,DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocEstudios estudios ){
        Doctor doctoNuevo = new Doctor(nombre,cedula, horarioInicial, horarioFinal,estudios, Optional.empty());
        return doctoNuevo;
    }
}
