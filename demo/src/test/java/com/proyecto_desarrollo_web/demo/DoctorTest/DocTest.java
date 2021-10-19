package com.proyecto_desarrollo_web.demo.DoctorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.ActualizarHoraIncial.ActualizadorHoraInicialDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.CrearDoctor.CrearDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.Encontrar.EncontarDoc;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DocTest {

    @Test
    void deveriaCrearCamion(){
        DoctorRepositorio repositorio= mock(DoctorRepositorio.class);

        CrearDoctor creador = new CrearDoctor(repositorio);

        Doctor doc = new Doctor(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"), new DocNombre("Diego"), new DocCedula(123456), new DocHorarioInicial(7), new DocHorarioFinal(14),new DocUsuario("Master"));

        creador.execute("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd", 123456, "Master", 7, 14, "Diego");

        verify(repositorio,atLeastOnce()).guardar(doc);
    }

    @Test
    void encontrarCamion(){
        DoctorRepositorio repositorio= mock(DoctorRepositorio.class);

        EncontarDoc buscador = new EncontarDoc(repositorio);

        Doctor doc = new Doctor(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"), new DocNombre("Diego"), new DocCedula(123456), new DocHorarioInicial(7), new DocHorarioFinal(14),new DocUsuario("Master"));

        Mockito.when(repositorio.encotrar(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"))).thenReturn(Optional.of(doc));

        assertEquals(doc, buscador.econtrar("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"));
    }
    @Test
    void cambiarHoraIncial(){
        DoctorRepositorio repositorio= mock(DoctorRepositorio.class);

        ActualizadorHoraInicialDoctor ac = new ActualizadorHoraInicialDoctor(repositorio);

        Doctor doc = new Doctor(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"), new DocNombre("Diego"), new DocCedula(123456), new DocHorarioInicial(7), new DocHorarioFinal(14),new DocUsuario("Master"));

        Mockito.when(repositorio.encotrar(new DocId("2188ec13-a26d-4b9f-a4b2-bfe88108d6fd"))).thenReturn(Optional.of(doc));
        ac.execute(2,"2188ec13-a26d-4b9f-a4b2-bfe88108d6fd");

        verify(repositorio,atLeastOnce()).guardar(doc);
    }

}
