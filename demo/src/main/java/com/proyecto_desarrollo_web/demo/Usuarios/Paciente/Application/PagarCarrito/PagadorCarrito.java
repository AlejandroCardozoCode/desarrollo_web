package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.PagarCarrito;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.CarritoComprasVacio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

import java.util.List;
import java.util.Optional;

public class PagadorCarrito {

    private PacienteRepositorio repo;

    private ServicioBuscarPaciente servicioBuscarPaciente;

    public PagadorCarrito(PacienteRepositorio repo){
        this.repo = repo;
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repo);
    }

    public void execute(String id) {
        Paciente paciente = servicioBuscarPaciente.execute(id);
        List<Producto> productosEnCarrito = paciente.verProductosCarrito();
        if (productosEnCarrito.isEmpty()) {
            throw new CarritoComprasVacio("El carrito de compras esta vacio");
        }
        Integer costoTotal = paciente.precioCarrito();
        for (int i = 0; i < productosEnCarrito.size(); i++)
        {
            productosEnCarrito.get(i).restarUnoCantidad();
            paciente.agregarCarritoFinal(productosEnCarrito.get(i));
        }
    }
}
