package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Controllers;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.CrearDoctor.CrearDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Doctro")
public class CreateDoctorPostController {
    @Autowired
    private CrearDoctor creator;

    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody DocRequest request)
    {
        this.creator.execute(request.getId(),request.getCedula(),request.getEstudios(),request.getHorarioInicial(),
                request.getHorarioFinal(),request.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(DocAlreadyExist.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerDocAlreadyExist(DocAlreadyExist exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({CedulaInvalida.class, EstudiosCaracteresNoValidos.class, EstudiosTamNoValido.class,
            HorarioFinalNoValido.class,HorarioInicialNoValido.class,NombreNoValido.class,NombreCaracteresNoValidos.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handlerBadRequest(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    static class DocRequest{
        private String id;
        private Integer cedula;
        private String estudios;
        private Integer horarioInicial;
        private Integer horarioFinal;
        private String nombre;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getCedula() {
            return cedula;
        }

        public void setCedula(Integer cedula) {
            this.cedula = cedula;
        }

        public String getEstudios() {
            return estudios;
        }

        public void setEstudios(String estudios) {
            this.estudios = estudios;
        }

        public Integer getHorarioInicial() {
            return horarioInicial;
        }

        public void setHorarioInicial(Integer horarioInicial) {
            this.horarioInicial = horarioInicial;
        }

        public Integer getHorarioFinal() {
            return horarioFinal;
        }

        public void setHorarioFinal(Integer horarioFinal) {
            this.horarioFinal = horarioFinal;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public DocRequest()
        {

        }
    }
}
