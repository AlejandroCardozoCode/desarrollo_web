package com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions;

public class ElProductoYaExiste extends RuntimeException{
    public ElProductoYaExiste(String s) {
        super(s);
    }

}
