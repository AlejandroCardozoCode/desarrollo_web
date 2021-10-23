package com.proyecto_desarrollo_web.demo.Producto.Application.ActualizarPrecio;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Services.ServicioBuscarProducto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoPrecio;

public class ActualizadorPrecio {

    private ProductoRepositorio repo;

    public ServicioBuscarProducto servicioBuscarProducto;

    public ActualizadorPrecio(ProductoRepositorio repo)
    {
       this.repo = repo;
       servicioBuscarProducto = new ServicioBuscarProducto(this.repo);
    }

    public void execute(Integer precio, String id){
        Producto producto = servicioBuscarProducto.execute(id);
        producto.actualizarPrecio(new ProductoPrecio(precio));
        repo.save(producto);
    }
}
