package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.ActualizarHoraFinal.ActualizarHoraFianlDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.ActualizarHoraIncial.ActualizadorHoraInicialDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.HorarioFinalNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.HorarioInicialNoValido;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.idDoctorNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Doctor")
public class actualizarHoraFinalController {


    @Autowired
    private ActualizarHoraFianlDoctor actu;

    @PostMapping(value = "/ActualizarHF")
    public ResponseEntity execute(@RequestBody  Actualizador request){
        this.actu.execute(request.getHoraFinal(), request.getId());
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

    @ExceptionHandler(HorarioFinalNoValido.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerDoctorExiste(HorarioFinalNoValido exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    static class Actualizador{
        private String id;
        private Integer horaFinal;

        Actualizador(){}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getHoraFinal() {
            return horaFinal;
        }

        public void setHoraFinal(Integer horaFinal) {
            this.horaFinal = horaFinal;
        }
    }

}
