package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.PagarCarrito;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services.ServicioBuscarCliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.CarritoComprasVacio;

import java.util.List;

public class PagadorCarrito {

    private ClienteRepo repo;

    private ServicioBuscarCliente servicioBuscarCliente;

    public PagadorCarrito(ClienteRepo repo){
        this.repo = repo;
        servicioBuscarCliente = new ServicioBuscarCliente(this.repo);
    }

    public void execute(String id) {
        Cliente cliente = servicioBuscarCliente.excecute(id);
        List<Producto> productosEnCarrito = cliente.verProductosCarrito();
        if (productosEnCarrito.isEmpty()) {
            throw new CarritoComprasVacio("El carrito de compras esta vacio");
        }
        Integer costoTotal = cliente.precioCarrito();
        for (int i = 0; i < productosEnCarrito.size(); i++)
        {
            productosEnCarrito.get(i).restarUnoCantidad();
            cliente.agregarCarritoFinal(productosEnCarrito.get(i));
        }
    }
}
