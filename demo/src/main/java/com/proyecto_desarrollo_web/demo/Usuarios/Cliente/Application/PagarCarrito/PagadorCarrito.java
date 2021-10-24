package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.PagarCarrito;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.ProductoCom;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services.ServicioBuscarCliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.CarritoComprasVacio;

import java.util.List;
import java.util.Optional;

public class PagadorCarrito {

    private ClienteRepo repo;

    private ServicioBuscarCliente servicioBuscarCliente;

    public PagadorCarrito(ClienteRepo repo){
        this.repo = repo;
        servicioBuscarCliente = new ServicioBuscarCliente(this.repo);
    }

    public void execute(String id) {
        Cliente cliente = servicioBuscarCliente.excecute(id);
        Optional<ProductoCom> productosEnCarrito = cliente.verProductosCarrito();
        if (productosEnCarrito.isEmpty()) {
            throw new CarritoComprasVacio("El carrito de compras esta vacio");
        }
        Integer costoTotal = cliente.precioCarrito();
            cliente.agregarCarritoFinal(productosEnCarrito);
    }
}
