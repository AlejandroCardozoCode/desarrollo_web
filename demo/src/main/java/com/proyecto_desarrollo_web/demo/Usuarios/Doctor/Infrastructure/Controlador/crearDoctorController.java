package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.CrearDoctor.CrearDoctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Exceptions.*;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping(value = "/Doctor")
public class crearDoctorController {

    @Autowired
    private CrearDoctor creador;

    @PostMapping(value = "/crear")
    public ResponseEntity execute(@RequestBody DoctorRequest request){
        this.creador.execute(request.getId(), request.getNombre(), request.getCedula(), request.getHoraInicial(), request.getHoraFinal(), request.getUsuario(), request.getContrasenna());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(DocAlreadyExist.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerDoctorExiste(DocAlreadyExist exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    @ExceptionHandler({CedulaInvalida.class, ContaDocNoValida.class, HorarioFinalNoValido.class, HorarioInicialNoValido.class, IdNoValido.class, NombreCaracteresNoValidos.class, UsuarioDocNoValido.class, UsuarioDocVacio.class})
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerPacienteExiste(RuntimeException exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class DoctorRequest {

        private String id;
        private String nombre;
        private Integer cedula;
        private Integer horaInicial;
        private Integer horaFinal;
        private String usuario;
        private String contrasenna;

        public DoctorRequest() {
        }

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

        public Integer getCedula() {
            return cedula;
        }

        public void setCedula(Integer cedula) {
            this.cedula = cedula;
        }

        public Integer getHoraInicial() {
            return horaInicial;
        }

        public void setHoraInicial(Integer horaInicial) {
            this.horaInicial = horaInicial;
        }

        public Integer getHoraFinal() {
            return horaFinal;
        }

        public void setHoraFinal(Integer horaFinal) {
            this.horaFinal = horaFinal;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getContrasenna() {
            return contrasenna;
        }

        public void setContrasenna(String contrasenna) {
            this.contrasenna = contrasenna;
        }
    }
    }
