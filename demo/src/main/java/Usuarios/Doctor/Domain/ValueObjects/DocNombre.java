package Usuarios.Doctor.Domain.ValueObjects;

import Usuarios.Doctor.Domain.Exceptions.EstudiosCaracteresNoValidos;
import Usuarios.Doctor.Domain.Exceptions.NombreCaracteresNoValidos;
import Usuarios.Doctor.Domain.Exceptions.NombreNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class DocNombre extends StringValueObject {

    private DocNombre(){}

    public DocNombre(String nombre)
    {
        validar(nombre);
        validarCaracteres(nombre);
        this.value = nombre;
    }

    private void validarCaracteres(String nombre) {
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        if (!p.matcher(nombre).find()) {
            throw new NombreCaracteresNoValidos("el nombre contiene caracteres no validos");

        }
    }



    private void validar(String nombre) {
        if(nombre.isEmpty() || nombre.equals(""))
        {
            throw new NombreNoValido("no se ha ingresado un valor en el nombre");
        }
    }


}
