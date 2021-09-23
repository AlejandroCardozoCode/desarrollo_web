package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.CedulaInvalida;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class DocCedula extends IntegerValueObject {

    private DocCedula(){
    }

    public DocCedula(Integer cedula){
        validarCedula(cedula);
        this.value = cedula;
    }

    private void validarCedula(Integer cedula) {
        int length = (int) (Math.log10(cedula) + 1);
        if(length < 5 ){
            throw new CedulaInvalida("la cedula ingresada no es valida");
        }
    }

}
