package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.Crear;

import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects.*;

public class CrearCliente {

    private ClienteRepo repo;

    public CrearCliente(ClienteRepo repo){
        this.repo = repo;
    }

    public void excecute(String id, String nombre, String usuario, String contrasena, Integer numero ){
        Cliente cliente = Cliente.Create(new ClienteId(id), new ClienteNombre(nombre), new ClienteUsuario(usuario), new ClienteContra(contrasena), new ClienteNumero(numero));
        repo.save(cliente);
    }
}