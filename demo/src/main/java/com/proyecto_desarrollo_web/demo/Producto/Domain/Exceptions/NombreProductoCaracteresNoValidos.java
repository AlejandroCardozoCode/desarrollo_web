package com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions;

public class NombreProductoCaracteresNoValidos extends RuntimeException {
    public NombreProductoCaracteresNoValidos(String s) {
        super(s);
    }
}
