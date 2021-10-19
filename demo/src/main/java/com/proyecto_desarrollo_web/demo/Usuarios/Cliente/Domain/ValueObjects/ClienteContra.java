package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.ContaClienteNoValida;

public class ClienteContra extends StringValueObject {

    private ClienteContra(){}

    public ClienteContra(String contra){
        validarTam(contra);
        this.value = contra;
    }

    private void validarTam(String contra){
        if(contra.length() < 5){
           throw new ContaClienteNoValida("La contraseña ingresada por el cliente no es lo suficientemente larga");
        }
    }
}
