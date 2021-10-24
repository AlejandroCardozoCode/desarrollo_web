package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Services;

import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.*;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Ports.AdminRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Admin;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects.AdminId;

import java.util.Optional;

public class ServicioBuscarAdmin {

    private AdminRepositorio repo;

    public ServicioBuscarAdmin(AdminRepositorio repo){
        this.repo = repo;
    }

    public Admin execute(String id){
        Optional<Admin> admin = repo.find(new AdminId(id));
        if(admin.isEmpty()){
            throw new IdAdminNoEncontrado("No se ha encontrado el id del Administrador");
        }
        return admin.get();
    }


}
