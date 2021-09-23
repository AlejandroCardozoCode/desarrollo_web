package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.HorarioInicialNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class DocHorarioInicial extends IntegerValueObject {

    private DocHorarioInicial(){}

    public DocHorarioInicial(Integer horarioInicial){
        validar(horarioInicial);
        this.value = horarioInicial;
    }

    private void validar(Integer horarioInicial) {
        if(horarioInicial < 0 || horarioInicial > 24)
        {
            throw new HorarioInicialNoValido("la hora inicial no es valida");
        }
    }
}
