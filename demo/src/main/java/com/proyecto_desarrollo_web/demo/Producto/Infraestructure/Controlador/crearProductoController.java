package com.proyecto_desarrollo_web.demo.Producto.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Producto.Application.CrearProducto.CreadorProducto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value ="/Producto")
public class crearProductoController {

    @Autowired
    private CreadorProducto creador;

    @PostMapping(value = "/crear")
    public ResponseEntity execute(@RequestBody ProductoRequest request)
    {
        this.creador.execute(request.getId(), request.getNombre(), request.getPrecio(), request.getCantidad());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(NombreProductoNoValido.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerProductoExiste(NombreProductoNoValido exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    static class ProductoRequest{

        private String id;
        private String nombre;
        private int precio;
        private int cantidad;

        public ProductoRequest(){}

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

        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    }



}