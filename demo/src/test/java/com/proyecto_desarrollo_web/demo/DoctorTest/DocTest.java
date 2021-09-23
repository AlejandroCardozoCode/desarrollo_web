package com.proyecto_desarrollo_web.demo.DoctorTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Exceptions.UUIDNotValid;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Application.Create.CreateDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Application.Encontrar.EncontarDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DocTest {

    @Test
    void deveriaCrearCamion(){
        DoctorRepositorio repositorio= mock(DoctorRepositorio.class);

        CreateDoctor creador = new CreateDoctor(repositorio);

        Doctor doc = new Doctor(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"), new DocNombre("Diego"), new DocCedula(123456), new DocHorarioInicial(7), new DocHorarioFinal(14),new DocEstudios("Master"));

        creador.execute("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd", 123456, "Master", 7, 14, "Diego");

        verify(repositorio,atLeastOnce()).guardar(doc);
    }

    @Test
    void encontrarCamion(){
        DoctorRepositorio repositorio= mock(DoctorRepositorio.class);

        EncontarDoctor buscador = new EncontarDoctor(repositorio);

        Doctor doc = new Doctor(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"), new DocNombre("Diego"), new DocCedula(123456), new DocHorarioInicial(7), new DocHorarioFinal(14),new DocEstudios("Master"));

        Mockito.when(repositorio.encotrar(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"))).thenReturn(Optional.of(doc));

        assertEquals(doc, buscador.econtrar("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"));
    }


}
