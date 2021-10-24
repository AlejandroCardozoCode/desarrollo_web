package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities;

import java.util.HashMap;
import java.util.Objects;

public class ProductoCom {
    private String id;
    private String nombre;
    private Integer precio;
    private Integer cantidad;

    public ProductoCom(String id, String nombre, Integer precio, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("id",id);
            put("nombre",nombre);
            put("precio",precio);
            put("cantidad",cantidad);
        }};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoCom productos = (ProductoCom) o;
        return id.equals(productos.id) && nombre.equals(productos.nombre) && precio.equals(productos.precio) && cantidad.equals(productos.cantidad);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, cantidad);
    }
}