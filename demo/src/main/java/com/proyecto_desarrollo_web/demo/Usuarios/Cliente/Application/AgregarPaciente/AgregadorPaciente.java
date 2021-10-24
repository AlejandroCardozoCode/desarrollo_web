package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.AgregarPaciente;


import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.PacienteCli;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services.ServicioBuscarCliente;

import java.util.Optional;

public class AgregadorPaciente {

    private ClienteRepo repo;
    private ServicioBuscarCliente servicioBuscarCliente;

    public AgregadorPaciente(ClienteRepo repo){
        this.repo = repo;
        servicioBuscarCliente = new ServicioBuscarCliente(this.repo);
    }
    public void execute(String clienteId, String idPaciente,String animal,String raza, Integer edad){
        Cliente cliente = servicioBuscarCliente.excecute(clienteId);
        PacienteCli paciente = new PacienteCli(idPaciente,animal,raza,edad);
        Optional<PacienteCli> opt = Optional.of(paciente);
        cliente.agregarMascota(opt);
    }
}
