package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoCantidad;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.PacienteCli;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.ProductoCom;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public class Cliente {
    private ClienteId id;
    private ClienteNombre nombre;
    private ClienteUsuario usuario;
    private ClienteContra contrasena;
    private ClienteNumero numero;
    private Optional<PacienteCli> arregloMascotas;
    private Optional<ProductoCom> productosComprados;
    private Optional<ProductoCom> productosSinComprar;

    private Cliente(){}
    public Cliente(ClienteId id, ClienteNombre nombre, ClienteUsuario usuario, ClienteContra contrasena, ClienteNumero numero) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numero = numero;
        this.arregloMascotas = Optional.empty();
        this.productosComprados = Optional.empty();
        this.productosSinComprar = Optional.empty();
    }

    public static Cliente Create(ClienteId id, ClienteNombre nombre, ClienteUsuario usuario, ClienteContra contrasena, ClienteNumero numero)
    {
        Cliente clienteNuevo = new Cliente(id,nombre, usuario, contrasena,numero);
        return clienteNuevo;
    }

    public void actualizarContraseña(ClienteContra contraNueva){
        this.contrasena = contraNueva;
    }

    public void agregarMascota(Optional<PacienteCli> paciente){
        this.arregloMascotas = paciente;
    }

    public Optional<ProductoCom> verProductosCarrito(){
        return this.productosSinComprar;
    }

    public Integer precioCarrito(){
        Integer valor = 0;
        valor = productosSinComprar.get().getCantidad() * productosSinComprar.get().getPrecio();
        return valor;
    }
    public void agregarCarrito(Optional<ProductoCom> producto){
        this.productosSinComprar = producto;
    }
    public void agregarCarritoFinal(Optional<ProductoCom> producto){
        this.productosComprados = producto;
    }

}
