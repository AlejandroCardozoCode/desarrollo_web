package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.EstudiosCaracteresNoValidos;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.EstudiosTamNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class DocEstudios extends StringValueObject {

    private DocEstudios(){}

    public DocEstudios(String estudios){
        lenghtValidate(estudios);
        letrasValidate(estudios);
        this.value = estudios;
    }

    private void lenghtValidate(String estudios) {
        if(estudios.length() < 5)
        {
            throw new EstudiosTamNoValido("la longitud de los estudios no es valida");
        }
    }
    private void letrasValidate(String estudios){
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        if (!p.matcher(estudios).find()) {
            throw new EstudiosCaracteresNoValidos("los estudios contienen caracteres no validos");
        }
    }
}
