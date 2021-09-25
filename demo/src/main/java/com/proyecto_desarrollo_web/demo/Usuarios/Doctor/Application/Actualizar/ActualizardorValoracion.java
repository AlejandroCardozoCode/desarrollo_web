package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.Actualizar;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.PacienteValoracion;

public class ActualizardorValoracion {
    private PacienteRepositorio repo;
    private ServicioBuscarPaciente servicioBuscarPaciente;


    public ActualizardorValoracion(PacienteRepositorio repo){
        this.repo = repo;
    }

    public void execute(String id,String nuevaValoracion){

        Paciente paciente = servicioBuscarPaciente.execute(id);
        paciente.actualizarValoracion(new PacienteValoracion(nuevaValoracion));
        repo.guardar(paciente);
    }

}
