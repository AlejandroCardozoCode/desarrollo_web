package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.NombrePacienteCaracteresNoValidos;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.NombrePacienteNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class PacienteNombre extends StringValueObject {

    private PacienteNombre(){}

    public PacienteNombre(String nombre){
        validarCaracteres(nombre);
        validar(nombre);
        this.value = nombre;
    }

    private void validarCaracteres(String nombre) {
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        if (!p.matcher(nombre).find()) {
            throw new NombrePacienteCaracteresNoValidos("el nombre contiene caracteres no validos");

        }
    }

    private void validar(String nombre) {
        if(nombre.isEmpty() || nombre.equals(""))
        {
            throw new NombrePacienteNoValido("no se ha ingresado un valor en el nombre");
        }
    }
}
