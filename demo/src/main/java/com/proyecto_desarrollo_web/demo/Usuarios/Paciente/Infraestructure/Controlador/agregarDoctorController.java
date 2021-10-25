package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.idDoctorNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.AgregarDoctorAsignado.AgregadorDoctorAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.idPacienteNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Paciente")
public class agregarDoctorController {

    @Autowired
    private AgregadorDoctorAsignado agregador;
    @PostMapping(value = "/agregar_doctor_asignado")
    public ResponseEntity execute(@RequestBody Request request){
        this.agregador.execute(request.getIdPaciente(), request.getIdDoctor());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(idPacienteNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerPacienteExiste(idPacienteNoEncontrado exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    @ExceptionHandler({idDoctorNoEncontrado.class})
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerPacienteExiste(RuntimeException exception){
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

        public String getIdDoctor() {
            return idDoctor;
        }

        public void setIdDoctor(String idDoctor) {
            this.idDoctor = idDoctor;
        }

    }

}
