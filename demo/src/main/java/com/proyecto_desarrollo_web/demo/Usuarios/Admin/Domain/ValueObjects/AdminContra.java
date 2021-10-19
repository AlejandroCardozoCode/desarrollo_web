package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.NombreAdminCaracteresNoValidos;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.NombreAdminNoValido;

import java.util.regex.Pattern;

public class AdminContra extends StringValueObject {

    private AdminContra(){}

    public AdminContra(String nombre)
    {
        validar(nombre);
        validarCaracteres(nombre);
        this.value = nombre;
    }

    private void validarCaracteres(String nombre) {
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        if (!p.matcher(nombre).find()) {
            throw new NombreAdminCaracteresNoValidos("El nombre contiene caracteres no validos");

        }
    }

    private void validar(String nombre) {
        if(nombre.isEmpty() || nombre.equals(""))
        {
            throw new NombreAdminNoValido("No se ha ingresado un valor en el nombre");
        }
    }
}
