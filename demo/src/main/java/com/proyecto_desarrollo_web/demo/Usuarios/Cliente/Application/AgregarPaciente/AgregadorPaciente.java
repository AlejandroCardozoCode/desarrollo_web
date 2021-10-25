package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.AgregarPaciente;


import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.PacienteCli;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Services.ServicioBuscarCliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Services.ServicioBuscarPaciente;

import java.util.Optional;

public class AgregadorPaciente {

    private ClienteRepo repo;
    private PacienteRepositorio repopa;
    private ServicioBuscarCliente servicioBuscarCliente;
    private ServicioBuscarPaciente servicioBuscarPaciente;

    public AgregadorPaciente(ClienteRepo repo, PacienteRepositorio repopa){
        this.repo = repo;
        this.repopa = repopa;
        servicioBuscarCliente = new ServicioBuscarCliente(this.repo);
        servicioBuscarPaciente = new ServicioBuscarPaciente(this.repopa);
    }
    public void execute(String clienteId, String idPaciente){
        Cliente cliente = servicioBuscarCliente.excecute(clienteId);
        Paciente paciente = servicioBuscarPaciente.execute(idPaciente);
        PacienteCli paciente2 = paciente.crearPacienteCliente();
        cliente.agregarMascota(paciente2);
        repo.save(cliente);
    }
}
