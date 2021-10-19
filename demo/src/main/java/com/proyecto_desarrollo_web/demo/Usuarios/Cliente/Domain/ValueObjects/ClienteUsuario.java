package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.UsuarioClienteNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.UsuarioClienteVacio;

import java.util.regex.Pattern;

public class ClienteUsuario extends StringValueObject {

    private ClienteUsuario(){}

    public ClienteUsuario(String usuario){

        validarNoVacio(usuario);
        validarCaracteres(usuario);
        this.value = usuario;
    }

    private void validarCaracteres(String nombre) {
        Pattern p = Pattern.compile("^[A-Za-z]\\w{5,29}$");
        if (!p.matcher(nombre).find()) {
            throw new UsuarioClienteNoValido("el usuario contiene caracteres no validos");

        }
    }

    private void validarNoVacio(String nombre) {
        if(nombre.isEmpty() || nombre.equals(""))
        {
            throw new UsuarioClienteVacio("no se ha ingresado un valor en el usuario");
        }
    }

}
