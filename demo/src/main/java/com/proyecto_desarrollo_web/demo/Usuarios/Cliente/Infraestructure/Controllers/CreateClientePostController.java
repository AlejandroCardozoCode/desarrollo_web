package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Infraestructure.Controllers;

import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.Crear.CrearCliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Cliente")
public class CreateClientePostController {

    @Autowired
    private CrearCliente agregador;

    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody ClienteRequest request)
    {
        this.agregador.execute(request.getId(),request.getNombre(),request.getUsuario(),request.getContrasena(),
                request.getNumero());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(ClienteExiste.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerClienteAlreadyExist(ClienteExiste exception)
    {
        HashMap<String,String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({NombreClienteVacio.class, NombreClienteNoVaido.class, NumeroClienteInvalido.class,
            UsuarioClienteNoValido.class, UsuarioClienteVacio.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handlerBadRequest(RuntimeException exception)
    {
        HashMap<String,String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class ClienteRequest{
        private String id;
        private String nombre;
        private String usuario;
        private String contrasena;
        private Integer numero;

        public ClienteRequest()
        {
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

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }

        public Integer getNumero() {
            return numero;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
        }
    }
}
