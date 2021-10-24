package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities.PacienteAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.*;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities.HistoriaClinicaPaciente;

import javax.swing.text.html.Option;
import java.util.ArrayList;
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
    private Optional<List<HistoriaClinicaPaciente>> arregloHistoriasDoc;

    private Doctor(){}
    public Doctor(DocId id,DocNombre nombre, DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocUsuario usuario, DocContrasenna contra, Optional<List<PacienteAsignado>> listaPacientes) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.usuario = usuario;
        this.contrasenna = contra;
        this.arregloPacientes = listaPacientes;
        this.arregloHistoriasDoc = Optional.empty();
    }

    public static Doctor Create(DocId id,DocNombre nombre,DocCedula cedula, DocHorarioInicial horarioInicial, DocHorarioFinal horarioFinal, DocUsuario usuario , DocContrasenna contra){
        Doctor doctoNuevo = new Doctor(id,nombre,cedula, horarioInicial, horarioFinal,usuario, contra, Optional.empty());
        return doctoNuevo;
    }

    public void agregarPacienteListaPacientes(PacienteAsignado paciente){
        if(!this.arregloPacientes.isPresent()){
            List<PacienteAsignado>nuevalista = new ArrayList();
            nuevalista.add(paciente);
            this.arregloPacientes = Optional.of(nuevalista);
        }
        else {
            this.arregloPacientes.get().add(paciente);
        }
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
