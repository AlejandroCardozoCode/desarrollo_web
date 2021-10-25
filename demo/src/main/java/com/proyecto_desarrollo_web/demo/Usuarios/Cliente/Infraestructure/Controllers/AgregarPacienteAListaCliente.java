package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Infraestructure.Controllers;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Exceptions.IdProductoNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.AgregarPaciente.AgregadorPaciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.CarritoComprasVacio;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.ClienteNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.idPacienteNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Cliente")
public class AgregarPacienteAListaCliente {

    @Autowired
    private AgregadorPaciente agregador;

    @PostMapping(value = "/agregar_paciente")
    public ResponseEntity execute(@RequestBody Request request){
        this.agregador.execute(request.getIdCliente(), request.getIdPaciente());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(idPacienteNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerClientNotFound(idPacienteNoEncontrado exception)
    {
        HashMap<String,String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    @ExceptionHandler({ClienteNoEncontrado.class, IdProductoNoEncontrado.class})
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerClientNotFound(RuntimeException exception)
    {
        HashMap<String,String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    static class Request{
        private String idCliente;
        private String idPaciente;
        public Request()
        {
        }

        public String getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(String idCliente) {
            this.idCliente = idCliente;
        }

        public String getIdPaciente() {
            return idPaciente;
        }

        public void setIdPaciente(String idPaciente) {
            this.idPaciente = idPaciente;
        }
    }
}
