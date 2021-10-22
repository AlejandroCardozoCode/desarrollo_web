package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;

public class PacienteIdCliente extends CustomUUID {

    public PacienteIdCliente(){}
    public PacienteIdCliente(String value){
        super(value);
    }
}
