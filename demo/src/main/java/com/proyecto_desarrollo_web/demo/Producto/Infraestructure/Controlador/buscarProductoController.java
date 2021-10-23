package com.proyecto_desarrollo_web.demo.Producto.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Producto.Application.Buscar.BuscarProducto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value ="/Producto")

public class buscarProductoController {

    @Autowired
    private BuscarProducto buscar;


    @PostMapping(value = "/busqueda")
    public ResponseEntity excecute(@RequestBody BusquedaRequest request){
        this.buscar.execute(request.getId());
        return ResponseEntity.status(HttpStatus.FOUND).body(null);
    }

    @ExceptionHandler(IdProductoNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerProductoExiste(IdProductoNoEncontrado exception){
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
