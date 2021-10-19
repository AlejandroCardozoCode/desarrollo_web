package com.proyecto_desarrollo_web.demo.Usuarios.Cliente;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Paciente;
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

    public Cliente(ClienteId id, ClienteNombre nombre, ClienteUsuario usuario, ClienteContra contrasena, ClienteNumero numero) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numero = numero;
        this.arregloMascotas = Optional.empty();
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
}
