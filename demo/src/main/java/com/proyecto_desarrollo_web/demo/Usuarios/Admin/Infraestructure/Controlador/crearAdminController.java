package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.CrearAdmin.CrearAdmin;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping(value ="/Admin")
public class crearAdminController {

    @Autowired
    private CrearAdmin creador;

    @PostMapping(value = "/crear")
    public ResponseEntity execute(@RequestBody AdminRequest request)
    {
        this.creador.execute(request.getId(), request.getUsuario(), request.getContra());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(ElAdminYaExiste.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerAdminYaExiste(ElAdminYaExiste exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(NombreAdminNoValido.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerNombreNoValido(NombreAdminNoValido exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(NombreAdminCaracteresNoValidos.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerCaracteresNoValidos(NombreAdminCaracteresNoValidos exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UsuarioAdminVacio.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerUsuarioVacio(UsuarioAdminVacio exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UsuarioAdminNoValido.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerUsuarioNoValido(UsuarioAdminNoValido exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class AdminRequest{

        private String id;
        private String usuario;
        private String contra;

        public AdminRequest(){}

        public String getId(){return id;}

        public void setId(String id){this.id = id; }

        public String getUsuario(){return usuario;}

        public void setUsuario(String usuario){this.usuario = usuario; }

        public String getContra(){return contra;}

        public void setContra(String contra){this.contra = contra; }

    }


}
