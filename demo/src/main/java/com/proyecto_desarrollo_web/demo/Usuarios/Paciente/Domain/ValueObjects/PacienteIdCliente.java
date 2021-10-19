package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.CedulaInvalida;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class PacienteIdCliente extends CustomUUID {

    public PacienteIdCliente(String value){
        super(value);
    }
}
