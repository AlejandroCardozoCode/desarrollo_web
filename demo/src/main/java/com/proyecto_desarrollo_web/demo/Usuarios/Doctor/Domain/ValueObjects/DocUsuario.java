package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.UsuarioDocNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.UsuarioDocVacio;

import java.util.regex.Pattern;

public class DocUsuario extends StringValueObject {

    private DocUsuario(){}

    public DocUsuario(String usuario){
        validadrNoVacio(usuario);
        validarCaracteres(usuario);
        this.value = usuario;
    }

    private void validadrNoVacio(String usuario) {
        if(usuario.isEmpty() || usuario.equals(""))
        {
            throw new UsuarioDocVacio("El usuario esta vacio");
        }
    }
    private void validarCaracteres(String usuario){
        Pattern p = Pattern.compile("^[A-Za-z]\\w{5,29}$");
        if (!p.matcher(usuario).find()) {
            throw new UsuarioDocNoValido("El usuario contiene caracteres no validos");

        }
    }
}
