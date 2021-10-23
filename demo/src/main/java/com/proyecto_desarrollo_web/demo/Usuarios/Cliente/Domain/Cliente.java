package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
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
    private Optional<List<Paciente>> arregloMascotas;
    private Optional<List<Producto>> productosComprados;
    private Optional<List<Producto>> productosSinComprar;

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

    public void agregarMascota(Paciente paciente){
        this.arregloMascotas.get().add(paciente);
    }

    public List<Producto> verProductosCarrito(){
        return this.productosSinComprar.get();
    }

    public Integer precioCarrito(){
        Integer valor = 0;
        for(int i= 0 ; i< productosSinComprar.get().size(); i++)
        {
            valor = valor + productosSinComprar.get().get(i).precio().value();
        }
        return valor;
    }
    public void agregarCarrito(Producto producto){
        this.productosSinComprar.get().add(producto);
    }
    public void agregarCarritoFinal(Producto producto){
        this.productosComprados.get().add(producto);
    }

}
