package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoCantidad;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.PacienteCli;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.ProductoCom;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities.PacienteAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cliente {
    private ClienteId id;
    private ClienteNombre nombre;
    private ClienteUsuario usuario;
    private ClienteContra contrasena;
    private ClienteNumero numero;
    private Optional<List<PacienteCli>> arregloMascotas;
    private Optional<List<ProductoCom>> productosComprados;

    private Cliente(){}
    public Cliente(ClienteId id, ClienteNombre nombre, ClienteUsuario usuario, ClienteContra contrasena, ClienteNumero numero, Optional<List<ProductoCom>> productosComprados, Optional<List<PacienteCli>> pacientes) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numero = numero;
        this.productosComprados = productosComprados;
        this.arregloMascotas = pacientes;
    }

    public static Cliente Create(ClienteId id, ClienteNombre nombre, ClienteUsuario usuario, ClienteContra contrasena, ClienteNumero numero)
    {
        Cliente clienteNuevo = new Cliente(id,nombre, usuario, contrasena,numero, Optional.empty(), Optional.empty());
        return clienteNuevo;
    }

    public void actualizarContraseña(ClienteContra contraNueva){
        this.contrasena = contraNueva;
    }

    public void agregarCarritoFinal(ProductoCom producto){
        if(!this.productosComprados.isPresent()){
            List<ProductoCom>nuevalista = new ArrayList();
            nuevalista.add(producto);
            this.productosComprados = Optional.of(nuevalista);
        }
        else {
            this.productosComprados.get().add(producto);
        }
    }
    public void agregarMascota(PacienteCli paciente){
        if(!this.arregloMascotas.isPresent()){
            List<PacienteCli>nuevalista = new ArrayList();
            nuevalista.add(paciente);
            this.arregloMascotas = Optional.of(nuevalista);
        }
        else {
            this.arregloMascotas.get().add(paciente);
        }
    }

}
