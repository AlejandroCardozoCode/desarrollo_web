package com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions;

public class PrecioNoValido extends RuntimeException {
    public PrecioNoValido(String s) {
        super(s);
    }
}
