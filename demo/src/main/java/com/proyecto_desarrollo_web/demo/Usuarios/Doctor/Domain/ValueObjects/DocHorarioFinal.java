package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.HorarioFinalNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class DocHorarioFinal extends IntegerValueObject{

    private DocHorarioFinal(){}

    public DocHorarioFinal(Integer horarioFinal){
        validar(horarioFinal);
        this.value = horarioFinal;
    }

    private void validar(Integer horarioFinal) {
        if(horarioFinal < 12 || horarioFinal > 24)
        {
            throw new HorarioFinalNoValido("La hora final no es valida");
        }
    }
}
