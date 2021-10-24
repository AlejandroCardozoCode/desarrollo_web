package com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.NombreProductoCaracteresNoValidos;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.NombreProductoNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class ProductoNombre extends StringValueObject {

    private ProductoNombre(){}

    public ProductoNombre(String nombre){
        validarCaracteres(nombre);
        validar(nombre);
        this.value = nombre;
    }

    private void validarCaracteres(String nombre) {
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        if (!p.matcher(nombre).find()) {
            throw new NombreProductoCaracteresNoValidos("el nombre del producto contiene caracteres no validos");

        }
    }

    private void validar(String nombre) {
        if(nombre.isEmpty() || nombre.equals(""))
        {
            throw new NombreProductoNoValido("no se ha ingresado un valor en el nombre del producto");
        }
    }
}
