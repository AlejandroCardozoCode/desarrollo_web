package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate.CustomUUID;

public class ClienteId extends CustomUUID {
   public ClienteId(String value){
       super(value);
   }

}
