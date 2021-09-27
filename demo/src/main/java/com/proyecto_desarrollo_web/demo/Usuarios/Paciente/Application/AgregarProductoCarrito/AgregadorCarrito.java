package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.AgregarProductoCarrito;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Services.ServicioBuscarProducto;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

public class AgregadorCarrito {
    private PacienteRepositorio repo;
    private ProductoRepositorio repoProducto;

   private ServicioBuscarPaciente servicioBuscarPaciente;
   private ServicioBuscarProducto servicioBuscarProducto;

   public AgregadorCarrito(PacienteRepositorio repo, ProductoRepositorio repoProducto){
       this.repo = repo;
       this.repoProducto = repoProducto;
       servicioBuscarPaciente = new ServicioBuscarPaciente(this.repo);
       servicioBuscarProducto = new ServicioBuscarProducto(this.repoProducto);
   }

   public  void execute(String id, String idProducto){
       Paciente paciente = servicioBuscarPaciente.execute(id);
       Producto producto = servicioBuscarProducto.execute(idProducto);
       paciente.agregarCarrito(producto);
   }
}
