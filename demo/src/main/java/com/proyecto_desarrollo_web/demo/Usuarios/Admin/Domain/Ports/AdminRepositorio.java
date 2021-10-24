package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Ports;

import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Admin;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects.AdminId;

import java.util.Optional;

public interface AdminRepositorio {
    void save(Admin admin);
    void delete(Admin admin);
    Optional<Admin> find(AdminId id);
}
