package com.proyecto_desarrollo_web.demo.Tienda.Domain;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Tienda {

    private Optional<List<Producto>> listaProductos;

    public Tienda() {
        this.listaProductos = Optional.empty();
    }

    public static Tienda crear(){
        Tienda tienda = new Tienda();
        return tienda;
    }

    public void removerUnProducto(Producto producto){
       this.listaProductos.get().remove(producto);
    }

    public void agregarProducto(Producto producto){
        this.listaProductos.get().add(producto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tienda tienda = (Tienda) o;
        return Objects.equals(listaProductos, tienda.listaProductos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaProductos);
    }
}
