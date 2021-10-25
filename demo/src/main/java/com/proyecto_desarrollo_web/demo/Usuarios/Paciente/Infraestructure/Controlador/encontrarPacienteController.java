package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.Encontrar.EncontrarPaciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.ElPacienteYaExiste;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.idPacienteNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Paciente")
public class encontrarPacienteController {

    @Autowired
    private EncontrarPaciente encontrar;

    @GetMapping(value = "/buscar")
    public ResponseEntity excecute(@RequestBody BusquedaRequest request){
        Paciente paciente = this.encontrar.buscar(request.getId());
        HashMap<String, String> response = paciente.respuestaFind();
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @ExceptionHandler(idPacienteNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerPacienteExiste(idPacienteNoEncontrado exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    static class BusquedaRequest{
        private String id;

        public BusquedaRequest(){}
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}

