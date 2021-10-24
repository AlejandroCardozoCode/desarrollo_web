package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.EliminarAdmin;

import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Ports.AdminRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Admin;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Services.ServicioBuscarAdmin;


public class EliminarAdmin {

    private AdminRepositorio repo;

    private ServicioBuscarAdmin servicioBuscarAdmin;

    public EliminarAdmin(AdminRepositorio repo){

        this.repo = repo;
        servicioBuscarAdmin = new ServicioBuscarAdmin(this.repo);

    }

    public void execute (String id){
        Admin admin = servicioBuscarAdmin.execute(id);
        repo.delete(admin);
    }


}
