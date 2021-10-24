package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain;

import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects.AdminContra;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects.AdminId;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects.AdminUsuario;

import java.util.Objects;

public class Admin {
    private AdminId id;
    private AdminUsuario usuario;
    private AdminContra contra;

    private Admin(){}

    public Admin(AdminId id, AdminUsuario usuario, AdminContra contra){
        this.id = id;
        this.usuario = usuario;
        this.contra = contra;
    }

    public static Admin crear(AdminId id, AdminUsuario usuario, AdminContra contra){
        Admin adminNuevo = new Admin(id, usuario, contra);
        return adminNuevo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) && Objects.equals(usuario, admin.usuario) && Objects.equals(contra, admin.contra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, contra);
    }


}
