package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.PacienteId;

import java.util.Optional;

public interface PacienteRepositorio {
    void guardar(Paciente actual);
    Optional<Paciente> buscar(PacienteId id);
}
