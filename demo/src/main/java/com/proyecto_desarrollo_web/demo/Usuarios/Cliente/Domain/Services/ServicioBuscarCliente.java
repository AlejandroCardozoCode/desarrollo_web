package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services;

import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.ClienteNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects.ClienteId;

import java.util.Optional;

public class ServicioBuscarCliente {

    private ClienteRepo repo;

    public ServicioBuscarCliente(ClienteRepo repo){
        this.repo = repo;
    }

    public Cliente excecute(String id){
        Optional<Cliente> clienteOptional = repo.find(new ClienteId(id));
        if(clienteOptional.isEmpty()){
            throw new ClienteNoEncontrado("El cliente con ese id no existe en el sistema");
        }
        return clienteOptional.get();
    }
}
