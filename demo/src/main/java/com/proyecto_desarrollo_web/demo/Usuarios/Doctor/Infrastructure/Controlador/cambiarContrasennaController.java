package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.CambiarContra.CambiarContra;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.ContaDocNoValida;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.HorarioInicialNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.idDoctorNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Doctor")
public class cambiarContrasennaController {

    @Autowired
    private CambiarContra cambiador;

    @PostMapping(value = "/contra")
    public ResponseEntity execute(@RequestBody Request request){
        this.cambiador.execute(request.getId(), request.getnuevaContra());
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

    @ExceptionHandler(ContaDocNoValida.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerDoctorExiste(ContaDocNoValida exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class Request{
        private String id;
        private String nuevaContra;

        Request(){}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getnuevaContra() {
            return nuevaContra;
        }

        public void setNuevaContra(String nuevaContra) {
            this.nuevaContra = nuevaContra;
        }
    }


}
