package com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions;

public class NombreProductoNoValido extends RuntimeException {
    public NombreProductoNoValido(String s) {
        super(s);
    }
}
