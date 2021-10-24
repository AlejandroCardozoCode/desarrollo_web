package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.AgregarProductoCarrito;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Services.ServicioBuscarProducto;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.ProductoCom;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services.ServicioBuscarCliente;

import java.util.Optional;

public class AgregadorCarrito {
    private ClienteRepo repo;
    private ProductoRepositorio repoProducto;

   private ServicioBuscarCliente servicioBuscarCliente;
   private ServicioBuscarProducto servicioBuscarProducto;

   public AgregadorCarrito(ClienteRepo repo, ProductoRepositorio repoProducto){
       this.repo = repo;
       this.repoProducto = repoProducto;
       servicioBuscarCliente = new ServicioBuscarCliente(this.repo);
       servicioBuscarProducto = new ServicioBuscarProducto(this.repoProducto);
   }

   public  void execute(String id, String idProducto, String nombre, Integer precio, Integer cantidad){
       Cliente cliente = servicioBuscarCliente.excecute(id);
       ProductoCom producto = new ProductoCom(idProducto,nombre,precio,cantidad);
       Optional<ProductoCom> opt = Optional.of(producto);
       cliente.agregarCarrito(opt);
   }
}
