package com.proyecto_desarrollo_web.demo.Producto.Application.ActualizarStock;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Services.ServicioBuscarProducto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoCantidad;

public class ActualiadorStock {

    private ProductoRepositorio repo;

    private ServicioBuscarProducto servicioBuscarProducto;

    public ActualiadorStock(ProductoRepositorio repo){
        this.repo = repo;
        servicioBuscarProducto = new ServicioBuscarProducto(this.repo);
    }

    public void execute(Integer cantidad, String id){
        Producto producto = servicioBuscarProducto.execute(id);
        producto.actualizarCantidad(new ProductoCantidad(cantidad));
        repo.save(producto);
    }
}
