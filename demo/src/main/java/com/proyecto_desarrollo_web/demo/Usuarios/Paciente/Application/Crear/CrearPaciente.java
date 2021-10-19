package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.Crear;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.*;

public class CrearPaciente {

    private PacienteRepositorio repo;

    public CrearPaciente(PacienteRepositorio repo){
        this.repo = repo;
    }
    public void execute(String id, String nombre, String animal, String idCliente, Integer edad, String raza){

        Paciente paciente = Paciente.crear(new PacienteId(id),new PacienteNombre(nombre), new PacienteAnimal(animal), new PacienteRaza(raza), new PacienteEdad(edad), new PacienteIdCliente(idCliente));
        repo.guardar(paciente);
    }
}
