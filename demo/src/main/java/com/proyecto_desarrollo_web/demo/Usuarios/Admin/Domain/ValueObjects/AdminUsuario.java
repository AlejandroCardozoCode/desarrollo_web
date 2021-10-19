package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.UsuarioAdminNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.UsuarioAdminVacio;

import java.util.regex.Pattern;

public class AdminUsuario extends StringValueObject {

    private AdminUsuario() {
    }

    public AdminUsuario(String usuario) {
        validadrNoVacio(usuario);
        validarCaracteres(usuario);
        this.value = usuario;
    }

    private void validadrNoVacio(String usuario) {
        if (usuario.isEmpty() || usuario.equals("")) {
            throw new UsuarioAdminVacio("El usuario esta vacio");
        }
    }

    private void validarCaracteres(String usuario) {
        Pattern p = Pattern.compile("^[A-Za-z]\\w{5,29}$");
        if (!p.matcher(usuario).find()) {
            throw new UsuarioAdminNoValido("El usuario contiene caracteres no validos");

        }
    }
}
