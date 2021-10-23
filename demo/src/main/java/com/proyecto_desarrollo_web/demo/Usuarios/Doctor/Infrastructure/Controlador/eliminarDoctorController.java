package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.idDoctorNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.BorrarDoctor.EliminarDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Doctor")
public class eliminarDoctorController {

    @Autowired
    private EliminarDoctor eliminador;

    @PostMapping(value = "/borrar")
    public ResponseEntity execute(@RequestBody Request request){
        this.eliminador.execute(request.getId());
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
        private String id;

        Request(){}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

}
