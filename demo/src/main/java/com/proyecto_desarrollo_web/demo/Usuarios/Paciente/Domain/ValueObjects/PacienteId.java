package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;

public class PacienteId extends  CustomUUID{
    private PacienteId(){}
    public PacienteId(String value)
    {
        super(value);
    }
}
