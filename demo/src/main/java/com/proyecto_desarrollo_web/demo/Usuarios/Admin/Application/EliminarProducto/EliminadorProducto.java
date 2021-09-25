package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.EliminarProducto;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Services.ServicioBuscarProducto;
import com.proyecto_desarrollo_web.demo.Tienda.Domain.Tienda;

public class EliminadorProducto {

    private ProductoRepositorio repo;

    private ServicioBuscarProducto servicioBuscarProducto;

    public EliminadorProducto(ProductoRepositorio repo){
        this.repo = repo;
        servicioBuscarProducto = new ServicioBuscarProducto(this.repo);
    }

    public void execute(String id, Tienda tienda){
        Producto producto = servicioBuscarProducto.execute(id);
        tienda.removerUnProducto(producto);
    }
}
