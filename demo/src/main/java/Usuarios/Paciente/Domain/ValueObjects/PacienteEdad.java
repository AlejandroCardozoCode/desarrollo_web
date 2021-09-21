package Usuarios.Paciente.Domain.ValueObjects;


import Usuarios.Paciente.Domain.Exceptions.EdadPacienteNoValida;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.IntegerValueObject;

public class PacienteEdad extends IntegerValueObject {

    private PacienteEdad(){}

    public PacienteEdad(Integer edad){
       validadEdad(edad);
       this.value = edad;
    }

    private void validadEdad(Integer edad) {
        if(edad <= 0)
        {
            throw new EdadPacienteNoValida("la edad del pacient no es valida");
        }
    }
}
