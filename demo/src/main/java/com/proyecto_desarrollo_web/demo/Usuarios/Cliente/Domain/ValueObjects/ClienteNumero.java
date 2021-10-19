package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.NumeroClienteInvalido;

public class ClienteNumero extends IntegerValueObject {

    private ClienteNumero(){}

    public ClienteNumero(Integer numero){
        validarTam(numero);
        this.value = numero;
    }

    private void validarTam(Integer numero)
    {
       if(String.valueOf(numero).length() < 5){
           throw new NumeroClienteInvalido("El numero no es lo suficientemente largo");
       }
    }
}

