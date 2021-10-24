package com.proyecto_desarrollo_web.demo.Producto.Infraestructure.Controlador;


import com.proyecto_desarrollo_web.demo.Producto.Application.ActualizarPrecio.ActualizadorPrecio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.PrecioNoValido;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.IdProductoNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;


@RestController
@RequestMapping(value = "/Producto")

public class actualizarPrecioController {

    @Autowired
    private ActualizadorPrecio actualizar;

    @PostMapping(value = "/ActualizarPrecio")
    public ResponseEntity execute(@RequestBody Actualizador request){
        this.actualizar.execute(request.getPrecio(), request.getId());
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @ExceptionHandler(IdProductoNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerProductoExiste(IdProductoNoEncontrado exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(PrecioNoValido.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerCantidadInvalida(PrecioNoValido exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    static class Actualizador{
        private String id;
        private Integer precio;

        Actualizador(){}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getPrecio() {
            return precio;
        }

        public void setPrecio(Integer horaFinal) {
            this.precio = horaFinal;
        }
    }

}
