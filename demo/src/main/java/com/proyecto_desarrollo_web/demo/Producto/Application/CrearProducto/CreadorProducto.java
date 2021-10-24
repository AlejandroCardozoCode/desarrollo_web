package com.proyecto_desarrollo_web.demo.Producto.Application.CrearProducto;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoCantidad;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoId;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoNombre;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoPrecio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.ElProductoYaExiste;

import java.util.Optional;

public class CreadorProducto {

    private ProductoRepositorio repo;

    public CreadorProducto(ProductoRepositorio repo){
        this.repo = repo;
    }


    public void execute(String id, String nombre, Integer precio, Integer cantidad){

        validate(id);
        Producto producto = Producto.crear(new ProductoId(id), new ProductoNombre(nombre), new ProductoPrecio(precio), new ProductoCantidad(cantidad));
        repo.save(producto);
    }

    public void validate(String id){
        Optional<Producto> producto = repo.find(new ProductoId(id));
        if(!producto.isEmpty()){
            throw new ElProductoYaExiste("Este producto ya existe en la base de datos");
        }
    }
}
