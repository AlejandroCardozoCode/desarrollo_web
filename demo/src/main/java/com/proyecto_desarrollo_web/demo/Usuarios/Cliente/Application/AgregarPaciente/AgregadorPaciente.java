package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.AgregarPaciente;


import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services.ServicioBuscarCliente;

public class AgregadorPaciente {

    private ClienteRepo repo;
    private ServicioBuscarCliente servicioBuscarCliente;

    public AgregadorPaciente(ClienteRepo repo){
        this.repo = repo;
        servicioBuscarCliente = new ServicioBuscarCliente(this.repo);
    }
    public void execute(Paciente paciente, String clienteId){
        Cliente cliente = servicioBuscarCliente.excecute(clienteId);
        cliente.agregarMascota(paciente);
    }
}
