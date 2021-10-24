package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Infraestructure.Controllers;

import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.AgregarProductoCarrito.AgregadorCarrito;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.CarritoComprasVacio;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.ClienteNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Cliente")
public class AddProductController {

    @Autowired
    private AgregadorCarrito agregador;

    @PostMapping(value = "/agregarCarrito")
    public ResponseEntity execute(@RequestBody AgregarCarritoRequest request)
    {
        this.agregador.execute(request.getIdCliente(),request.getIdProducto(),request.getNombre()
        ,request.getPrecio(),request.getCanidad());
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }
    @ExceptionHandler(CarritoComprasVacio.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerClientNotFound(ClienteNoEncontrado exception)
    {
        HashMap<String,String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
       return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class AgregarCarritoRequest{
        private String idCliente;
        private String idProducto;
        private String nombre;
        private Integer precio;
        private Integer canidad;

        public AgregarCarritoRequest()
        {

        }

        public String getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(String idCliente) {
            this.idCliente = idCliente;
        }

        public String getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(String idProducto) {
            this.idProducto = idProducto;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Integer getPrecio() {
            return precio;
        }

        public void setPrecio(Integer precio) {
            this.precio = precio;
        }

        public Integer getCanidad() {
            return canidad;
        }

        public void setCanidad(Integer canidad) {
            this.canidad = canidad;
        }
    }
}
