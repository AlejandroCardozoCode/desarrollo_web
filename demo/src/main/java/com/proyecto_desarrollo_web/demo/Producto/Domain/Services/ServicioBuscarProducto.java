package com.proyecto_desarrollo_web.demo.Producto.Domain.Services;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.IdProductoNoEncontrado;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoId;

import java.util.Optional;

public class ServicioBuscarProducto {

    private ProductoRepositorio repo;

    public ServicioBuscarProducto(ProductoRepositorio repo){
        this.repo = repo;
    }

    public Producto execute(String id){
        Optional<Producto> producto = repo.find(new ProductoId(id));
        if(producto.isEmpty()){
            throw new IdProductoNoEncontrado("No se ha encontrado el id del producto");
        }
        return producto.get();
    }
}
