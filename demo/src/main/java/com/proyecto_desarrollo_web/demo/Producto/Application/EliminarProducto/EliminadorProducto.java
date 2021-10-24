package com.proyecto_desarrollo_web.demo.Producto.Application.EliminarProducto;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Services.ServicioBuscarProducto;

public class EliminadorProducto {

    private ProductoRepositorio repo;

    private ServicioBuscarProducto servicioBuscarProducto;

    public EliminadorProducto(ProductoRepositorio repo){
        this.repo = repo;
        servicioBuscarProducto = new ServicioBuscarProducto(this.repo);
    }

    public void execute(String id){
        Producto producto = servicioBuscarProducto.execute(id);
        repo.delete(producto);
    }
}
