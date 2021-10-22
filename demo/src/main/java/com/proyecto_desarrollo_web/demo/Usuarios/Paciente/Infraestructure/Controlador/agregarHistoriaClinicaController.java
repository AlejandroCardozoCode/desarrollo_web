package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.AgregarHistoriaClinica.AgregadorHistoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Paciente")
public class agregarHistoriaClinicaController {

    @Autowired
    private AgregadorHistoria agregador;




}
