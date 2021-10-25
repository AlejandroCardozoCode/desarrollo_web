package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.RazaCaracteresNoValidos;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.RazaNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class PacienteRaza extends StringValueObject {
    private PacienteRaza(){}

    public PacienteRaza(String raza){
        validarCaracteres(raza);
        validar(raza);
        this.value = raza;
    }

    private void validarCaracteres(String raza) {
        Pattern p = Pattern.compile("^[\\p{L} .'-]+$");
        if (!p.matcher(raza).find()) {
            throw new RazaCaracteresNoValidos("el raza contiene caracteres no validos");
        }
    }

    private void validar(String raza) {
        if(raza.isEmpty() || raza.equals(""))
        {
            throw new RazaNoValido("no se ha ingresado un valor en el raza");
        }
    }
}
