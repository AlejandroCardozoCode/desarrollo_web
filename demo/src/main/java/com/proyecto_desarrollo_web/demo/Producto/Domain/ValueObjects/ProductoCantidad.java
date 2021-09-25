package com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.CantidadNoValido;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.PrecioNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class ProductoCantidad
extends IntegerValueObject {
    private ProductoCantidad(){}

    public ProductoCantidad(Integer cantidad){
        validarCantidad(cantidad);
        this.value = cantidad;
    }

    private void validarCantidad(Integer cantidad) {

        if(cantidad < 0)
        {
            throw new CantidadNoValido("La cantidad del producto no puede ser cero");
        }
    }

}
