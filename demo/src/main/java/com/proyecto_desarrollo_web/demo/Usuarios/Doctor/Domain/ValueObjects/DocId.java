package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;

public class DocId extends CustomUUID {
    private DocId(){}
    public DocId(String value)
    {
        super(value);
    }

}
