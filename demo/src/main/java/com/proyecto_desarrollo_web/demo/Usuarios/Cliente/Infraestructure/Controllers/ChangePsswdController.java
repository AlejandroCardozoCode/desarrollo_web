package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Infraestructure.Controllers;

import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Application.CambiarContra.CambiarContrasenna;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.ClienteNoEncontrado;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Exceptions.ContaClienteNoValida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Cliente")
public class ChangePsswdController {
    @Autowired
    private CambiarContrasenna changer;

    @PostMapping(value = "/changePas")
    public ResponseEntity execute(@RequestBody ChangerRequest request){
        this.changer.execute(request.getId(),request.getNuevaContra());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(ClienteNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerClientNotFound(ClienteNoEncontrado exception)
    {
        HashMap<String,String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ContaClienteNoValida.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity <HashMap> handlerContaNotValid(ContaClienteNoValida exception)
    {
        HashMap<String,String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class ChangerRequest{
        private String id;
        private String nuevaContra;

        ChangerRequest(){

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNuevaContra() {
            return nuevaContra;
        }

        public void setNuevaContra(String nuevaContra) {
            this.nuevaContra = nuevaContra;
        }
    }

}
