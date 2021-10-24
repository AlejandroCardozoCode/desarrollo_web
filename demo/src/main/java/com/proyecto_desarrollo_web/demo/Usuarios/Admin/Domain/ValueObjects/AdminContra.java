package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.NombreAdminCaracteresNoValidos;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.NombreAdminNoValido;

import java.util.regex.Pattern;

public class AdminContra extends StringValueObject {

    private AdminContra(){}

    public AdminContra(String contra)
    {
        validar(contra);
        this.value = contra;
    }


    private void validar(String contra) {
        if(contra.isEmpty() || contra.equals(""))
        {
            throw new NombreAdminNoValido("No se ha ingresado un valor en la contrasena");
        }
    }
}
