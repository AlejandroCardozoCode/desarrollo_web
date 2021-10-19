package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports;

import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects.ClienteId;

import java.util.Optional;

public interface ClienteRepo {

    void save(Cliente actual);
    void update(Cliente nuevo);
    Optional<Cliente> find(ClienteId id);
}
