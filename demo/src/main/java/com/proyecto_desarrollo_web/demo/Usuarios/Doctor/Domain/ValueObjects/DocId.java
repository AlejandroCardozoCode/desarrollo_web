package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.EstudiosCaracteresNoValidos;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.EstudiosTamNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.HorarioFinalNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.IdNoValido;

import java.util.regex.Pattern;

public class DocId extends CustomUUID {
    public DocId(String value)
    {
        super(value);
    }

}
