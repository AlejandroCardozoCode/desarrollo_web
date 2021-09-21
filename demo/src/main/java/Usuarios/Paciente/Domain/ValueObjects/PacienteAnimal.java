package Usuarios.Paciente.Domain.ValueObjects;

import Usuarios.Paciente.Domain.Exceptions.AnimalCaracteresNoValidos;
import Usuarios.Paciente.Domain.Exceptions.AnimalNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class PacienteAnimal extends StringValueObject {
    
    private PacienteAnimal(){}
    
    public PacienteAnimal(String animal){
        validacionAnimal(animal);
        this.value = animal;
    }

    private void validacionAnimal(String animal) {
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        if (!p.matcher(animal).find()) {
            throw new AnimalCaracteresNoValidos("el valor de animal contiene caracteres no validos");
        }
    }
    private void validar(String animal) {
        if(animal.isEmpty() || animal.equals(""))
        {
            throw new AnimalNoValido("no se ha ingresado un valor en el animal");
        }
    }
}
