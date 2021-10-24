package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.IdProductoNoEncontrado;
import com.proyecto_desarrollo_web.demo.Producto.Infraestructure.Controlador.eliminarProductoController;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Exceptions.*;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Application.EliminarAdmin.EliminarAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Admin")

public class eliminarAdminController {

    @Autowired
    private EliminarAdmin eliminador;

    @PostMapping(value = "/borrar")

    public ResponseEntity execute(@RequestBody Request request){
        this.eliminador.execute(request.getId());
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @ExceptionHandler(IdAdminNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerAdminNoExiste(IdAdminNoEncontrado exception){
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
