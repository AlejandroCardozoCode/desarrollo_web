package com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;

public class ProductoId extends CustomUUID {

    public  ProductoId(String value)
    {
        super(value);
    }
}
