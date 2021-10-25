package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.NombreClienteNoVaido;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.NombreClienteVacio;

import java.util.regex.Pattern;

public class ClienteNombre extends StringValueObject {

    private ClienteNombre(){

    }

    public ClienteNombre(String nombre){
       validar(nombre);
       validarCaracteres(nombre);
       this.value = nombre;
    }
    private void validarCaracteres(String nombre) {
        Pattern p = Pattern.compile("^[\\p{L} .'-]+$");
        if (!p.matcher(nombre).find()) {
            throw new NombreClienteNoVaido("El nombre contiene caracteres no validos");

        }
    }

    private void validar(String nombre) {
        if(nombre.isEmpty() || nombre.equals(""))
        {
            throw new NombreClienteVacio("no se ha ingresado un valor en el nombre");
        }
    }
}
