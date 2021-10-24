package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.AgregarListaPacientes.AgregardorListaPacientes;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.idDoctorNoEncontrado;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Doctor")
public class agregarPaienteArreglo {

    @Autowired
    private AgregardorListaPacientes agregador;

    @PostMapping(value = "/agregar_paciente")
    public ResponseEntity execute(@RequestBody Request request){
       this.agregador.execute(request.getIdPaciente(), request.getIdDcotor());
       return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(idDoctorNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerDoctorExiste(idDoctorNoEncontrado exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    static class Request{

        private String idPaciente;
        private String idDoctor;

        public Request(){}

        public String getIdPaciente() {
            return idPaciente;
        }

        public void setIdPaciente(String idPaciente) {
            this.idPaciente = idPaciente;
        }

        public String getIdDcotor() {
            return idDoctor;
        }

        public void setIdDcotor(String idDcotor) {
            this.idDoctor = idDcotor;
        }
    }
    }

