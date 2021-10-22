package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.Crear;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.ElPacienteYaExiste;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.*;

import java.util.Optional;

public class CrearPaciente {

    private PacienteRepositorio repo;

    public CrearPaciente(PacienteRepositorio repo){
        this.repo = repo;
    }
    public void execute(String id, String nombre, String animal, String idCliente, Integer edad, String raza){
        validate(id);
        Paciente paciente = Paciente.crear(new PacienteId(id),new PacienteNombre(nombre), new PacienteAnimal(animal), new PacienteRaza(raza), new PacienteEdad(edad), new PacienteIdCliente(idCliente));
        repo.guardar(paciente);
    }

    public void validate(String id){
        Optional<Paciente> paciente = repo.buscar(new PacienteId(id));
        if(!paciente.isEmpty()){
            throw new ElPacienteYaExiste("Este paciente ya existe en la base de datos");
        }
    }
}
