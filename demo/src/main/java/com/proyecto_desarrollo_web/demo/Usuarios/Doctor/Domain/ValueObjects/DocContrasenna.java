package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.ContaClienteNoValida;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.ContaDocNoValida;

public class DocContrasenna extends StringValueObject {

    private DocContrasenna(){
    }

    public DocContrasenna(String contra){
        validarTam(contra);
        this.value = contra;
    }

    private void validarTam(String contra) {
        if (contra.length() < 5) {
            throw new ContaDocNoValida("La contraseña ingresada por el Doctor no es lo suficientemente larga");
        }
    }
}
