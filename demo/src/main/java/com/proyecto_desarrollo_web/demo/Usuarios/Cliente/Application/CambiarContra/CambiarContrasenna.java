package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.CambiarContra;

import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services.ServicioBuscarCliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects.ClienteContra;

public class CambiarContrasenna {

    private ClienteRepo repo;
    private ServicioBuscarCliente servicioBuscarCliente;

    public CambiarContrasenna(ClienteRepo repo){
        this.repo = repo;
        servicioBuscarCliente = new ServicioBuscarCliente(this.repo);
    }

    public void execute(String id, String nuevaContra){
        Cliente cliente = servicioBuscarCliente.excecute(id);
        cliente.actualizarContraseña(new ClienteContra(nuevaContra));
        repo.save(cliente);
    }
}
