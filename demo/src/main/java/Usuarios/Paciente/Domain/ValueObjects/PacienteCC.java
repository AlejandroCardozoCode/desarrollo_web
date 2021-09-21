package Usuarios.Paciente.Domain.ValueObjects;

import Usuarios.Paciente.Domain.Exceptions.CedulaInvalida;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class PacienteCC extends IntegerValueObject {

    private PacienteCC(){}

    public PacienteCC(Integer cedula){
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
