package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.CrearAdmin;

import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.*;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Admin;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Ports.AdminRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects.*;

import java.util.Optional;


public class CrearAdmin {
    private AdminRepositorio repo;

    public CrearAdmin(AdminRepositorio repo ){
        this.repo = repo;
    }
    public void execute(String id, String usuario, String contra){
        validate(id);
        Admin admin = Admin.crear(new AdminId(id), new AdminUsuario(usuario), new AdminContra(contra));
        repo.save(admin);
    }

    public void validate(String id){
        Optional<Admin> admin = repo.find(new AdminId(id));
        if(!admin.isEmpty()){
            throw new ElAdminYaExiste("Este Administrador ya existe");
        }

    }

}
