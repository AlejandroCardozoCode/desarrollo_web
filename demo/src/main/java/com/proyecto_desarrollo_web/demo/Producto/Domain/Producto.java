package com.proyecto_desarrollo_web.demo.Producto.Domain;

import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoCantidad;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoId;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoNobmre;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoPrecio;

import java.util.Objects;

public class Producto {

    private ProductoId id;
    private ProductoNobmre nombre;
    private ProductoPrecio precio;
    private ProductoCantidad cantidad;

    public Producto(ProductoId id, ProductoNobmre nombre, ProductoPrecio precio, ProductoCantidad cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void actualizarPrecio(ProductoPrecio precio){
        this.precio = precio;
    }

    public void actualizarCantidad(ProductoCantidad cantidad){
        this.cantidad = cantidad;
    }

    public void restarUnoCantidad(){
        this.cantidad = new ProductoCantidad(this.cantidad.value() - 1);
    }

    public ProductoPrecio precio(){
        return  this.precio;
    }

    public static Producto crear(ProductoId id, ProductoNobmre nombre, ProductoPrecio precio, ProductoCantidad cantidad){
        Producto producto = new Producto(id, nombre, precio, cantidad);
        return producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }
}
