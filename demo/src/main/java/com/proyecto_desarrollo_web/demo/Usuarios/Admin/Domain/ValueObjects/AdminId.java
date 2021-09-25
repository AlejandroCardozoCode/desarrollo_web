package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;

public class AdminId extends CustomUUID {
    public AdminId(String value)
    {
        super(value);
    }
}
