package com.proyecto_desarrollo_web.demo.Producto.Application.CrearProducto;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoCantidad;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoId;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoNobmre;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoPrecio;

public class CreadorProducto {

    private ProductoRepositorio repo;

    public CreadorProducto(ProductoRepositorio repo){
        this.repo = repo;
    }


    public void execute(String id, String nombre, Integer precio, Integer cantidad){

        Producto producto = Producto.crear(new ProductoId(id), new ProductoNobmre(nombre), new ProductoPrecio(precio), new ProductoCantidad(cantidad));
        repo.guardar(producto);
    }
}
