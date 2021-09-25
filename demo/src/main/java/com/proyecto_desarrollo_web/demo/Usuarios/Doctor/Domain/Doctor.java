package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities.Citas;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.*;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.PacienteId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Doctor {
    private DocId id;
    private DocNombre nombre;
    private DocCedula cedula;
    private DocHorarioInicial horarioInicial;
    private DocHorarioFinal horarioFinal;
    private DocEstudios estudios;
    private Optional<List<Paciente>> arregloPacientes;
    private Optional<List<Citas>> arregloCitas;

    public Doctor(DocId id,DocNombre nombre, DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocEstudios estudios) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.estudios = estudios;
        this.arregloPacientes = Optional.empty();
        this.arregloCitas = Optional.empty();
    }

    public static Doctor Create(DocId id,DocNombre nombre,DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocEstudios estudios ){
        Doctor doctoNuevo = new Doctor(id,nombre,cedula, horarioInicial, horarioFinal,estudios);
        return doctoNuevo;
    }

    public void agregarPacienteListaPacientes(Paciente paciente){
        this.arregloPacientes.get().add(paciente);
    }
    public void agregarCita(Citas cita)
    {
        this.arregloCitas.get().add(cita);
    }

    public  void actualizarHoraInicial(DocHorarioInicial horaI){
        this.horarioInicial = horaI;
    }
    public  void actualizarHoraFinal(DocHorarioFinal horaF){
        this.horarioFinal = horaF;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(nombre, doctor.nombre) && Objects.equals(cedula, doctor.cedula) && Objects.equals(horarioInicial, doctor.horarioInicial) && Objects.equals(horarioFinal, doctor.horarioFinal) && Objects.equals(estudios, doctor.estudios) && Objects.equals(arregloPacientes, doctor.arregloPacientes) && Objects.equals(arregloCitas, doctor.arregloCitas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cedula, horarioInicial, horarioFinal, estudios, arregloPacientes, arregloCitas);
    }
}
