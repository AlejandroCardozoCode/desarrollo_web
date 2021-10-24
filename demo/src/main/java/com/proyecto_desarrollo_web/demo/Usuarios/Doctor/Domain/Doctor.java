package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain;

import com.proyecto_desarrollo_web.demo.Shared.Entities.HistoriaClinica;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities.PacienteAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.*;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Doctor {
    private DocId id;
    private DocNombre nombre;
    private DocCedula cedula;
    private DocHorarioInicial horarioInicial;
    private DocHorarioFinal horarioFinal;
    private DocUsuario usuario;
    private DocContrasenna contrasenna;
    private Optional<List<PacienteAsignado>> arregloPacientes;
    private Optional<List<HistoriaClinica>> arregloHistoriasDoc;

    private Doctor(){}
    public Doctor(DocId id,DocNombre nombre, DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocUsuario usuario, DocContrasenna contra) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.usuario = usuario;
        this.contrasenna = contra;
        this.arregloPacientes = Optional.empty();
        this.arregloHistoriasDoc = Optional.empty();
    }

    public static Doctor Create(DocId id,DocNombre nombre,DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocUsuario usuario , DocContrasenna contra){
        Doctor doctoNuevo = new Doctor(id,nombre,cedula, horarioInicial, horarioFinal,usuario, contra);
        return doctoNuevo;
    }

    public void agregarPacienteListaPacientes(PacienteAsignado paciente){
        this.arregloPacientes.get().add(paciente);
    }
    public void agregarCita(HistoriaClinica cita)
    {
        this.arregloHistoriasDoc.get().add(cita);
    }

    public  void actualizarHoraInicial(DocHorarioInicial horaI){
        this.horarioInicial = horaI;
    }
    public  void actualizarHoraFinal(DocHorarioFinal horaF){
        this.horarioFinal = horaF;
    }
    public void actualizarContra(DocContrasenna nuevaContra){
        this.contrasenna = nuevaContra;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(nombre, doctor.nombre) && Objects.equals(cedula, doctor.cedula) && Objects.equals(horarioInicial, doctor.horarioInicial) && Objects.equals(horarioFinal, doctor.horarioFinal) && Objects.equals(usuario, doctor.usuario) && Objects.equals(arregloPacientes, doctor.arregloPacientes) && Objects.equals(arregloHistoriasDoc, doctor.arregloHistoriasDoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cedula, horarioInicial, horarioFinal, usuario, arregloPacientes, arregloHistoriasDoc);
    }
}
