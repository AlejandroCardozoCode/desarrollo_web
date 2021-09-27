package com.proyecto_desarrollo_web.demo.Producto.Application.Buscar;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Services.ServicioBuscarProducto;

public class BuscarProducto {

    private ProductoRepositorio repo;

    private ServicioBuscarProducto servicioBuscarProducto;

    public BuscarProducto(ProductoRepositorio repo){
        this.repo = repo;
        servicioBuscarProducto = new ServicioBuscarProducto(this.repo);
    }

    public Producto execute(String id){
        return servicioBuscarProducto.execute(id);
    }
}
