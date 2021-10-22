package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.Crear.CrearPaciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value ="/Paciente")
public class createPacienteController {

    @Autowired
    private CrearPaciente creador;

    @PostMapping(value = "/crear")
    public ResponseEntity execute(@RequestBody PacienteRequest request)
    {
       this.creador.execute(request.getId(), request.getNombre(), request.getAnimal(), request.getIdCliente(), request.getEdad(), request.getRaza());
       return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(ElPacienteYaExiste.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerPacienteExiste(ElPacienteYaExiste exception){
       HashMap<String, String> response = new HashMap<>(){{
           put("Error", exception.getMessage());
       }};
       return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({AnimalCaracteresNoValidos.class, AnimalNoValido.class, EdadPacienteNoValida.class, NombrePacienteCaracteresNoValidos.class, NombrePacienteNoValido.class, RazaCaracteresNoValidos.class, RazaNoValido.class})
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerPacienteExiste(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class PacienteRequest{

        private String id;
        private String nombre;
        private String animal;
        private String idCliente;
        private Integer edad;
        private String raza;

        public PacienteRequest(){}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getAnimal() {
            return animal;
        }

        public void setAnimal(String animal) {
            this.animal = animal;
        }

        public String getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(String idCliente) {
            this.idCliente = idCliente;
        }

        public Integer getEdad() {
            return edad;
        }

        public void setEdad(Integer edad) {
            this.edad = edad;
        }

        public String getRaza() {
            return raza;
        }

        public void setRaza(String raza) {
            this.raza = raza;
        }
    }
}
