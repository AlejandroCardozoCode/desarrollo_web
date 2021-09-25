package com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.PrecioNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class ProductoPrecio extends IntegerValueObject {

    private ProductoPrecio(){
    }

    public ProductoPrecio(Integer precio){
       validarPrecio(precio);
       this.value = precio;
    }

    private void validarPrecio(Integer precio) {
        if(precio < 1000)
        {
            throw new PrecioNoValido("El precio no puede ser menor a 1000");
        }
    }
}
