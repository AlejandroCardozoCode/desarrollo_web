package Usuarios.Doctor.Domain.ValueObjects;

import Usuarios.Doctor.Domain.Exceptions.HorarioFinalNoValido;
import Usuarios.Doctor.Domain.Exceptions.HorarioInicialNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class DocHorarioFinal extends IntegerValueObject{

    private DocHorarioFinal(){}

    public DocHorarioFinal(Integer horarioInicial){
        validar(horarioInicial);
        this.value = horarioInicial;
    }

    private void validar(Integer horarioInicial) {
        if(horarioInicial < 0 || horarioInicial > 24)
        {
            throw new HorarioFinalNoValido("la hora inicial no es valida");
        }
    }
}
