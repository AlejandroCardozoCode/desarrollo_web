package Usuarios.Paciente.Domain.ValueObjects;

import Usuarios.Paciente.Domain.Exceptions.ValoracionCaracteresNoValidos;
import Usuarios.Paciente.Domain.Exceptions.ValoracionNoValido;
import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.StringValueObject;

import java.util.regex.Pattern;

public class PacienteValoracion extends StringValueObject {
    private PacienteValoracion(){}

    public PacienteValoracion(String valoracion){
        validarCaracteres(valoracion);
        validar(valoracion);
        this.value = valoracion;
    }

    private void validarCaracteres(String valoracion) {
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        if (!p.matcher(valoracion).find()) {
            throw new ValoracionCaracteresNoValidos("el valoracion contiene caracteres no validos");
        }
    }

    private void validar(String valoracion) {
        if(valoracion.isEmpty() || valoracion.equals(""))
        {
            throw new ValoracionNoValido("no se ha ingresado un valor en el valoracion");
        }
    }
}
